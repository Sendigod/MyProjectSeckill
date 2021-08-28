package com.sorrymaker.seckill.service.impl;

import com.sorrymaker.seckill.dao.SeckillDao;
import com.sorrymaker.seckill.dao.SuccessKilledDao;
import com.sorrymaker.seckill.dao.cache.RedisDao;
import com.sorrymaker.seckill.dto.Exposer;
import com.sorrymaker.seckill.dto.SeckillExecution;
import com.sorrymaker.seckill.entity.Seckill;
import com.sorrymaker.seckill.entity.SuccessKilled;
import com.sorrymaker.seckill.enums.SeckillStatEnum;
import com.sorrymaker.seckill.exception.RepeatKillException;
import com.sorrymaker.seckill.exception.SeckillCloseException;
import com.sorrymaker.seckill.exception.SeckillException;
import com.sorrymaker.seckill.service.SeckillService;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author nextGame
 * @Date 2021/8/9 19:17
 * @Version 1.0
 */

@Service
public class SeckillServiceImpl implements SeckillService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillDao seckillDao;

    @Autowired
    private SuccessKilledDao successKilledDao;

    @Autowired
    private RedisDao redisDao;

    private String slat = "sdasd_+d121@@asjj21..;da";

    private String getMD5(long seckillId) {
        //md5盐值字符串，用于混淆md5
        String base = seckillId + "/" + slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }


    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0, 100000);
    }

    public Seckill getById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    public Exposer exportSeckillUrl(long seckillId) {
        //优化：缓存优化
        //1.访问Redis
        Seckill seckill = redisDao.getSeckill(seckillId);
        if (seckill == null) {
            //2:访问数据库
            seckill = seckillDao.queryById(seckillId);
            if (seckill == null) {
                return new Exposer(false, seckillId);
            } else {
                //3:放入redis
                redisDao.putSeckill(seckill);
            }
        }
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        Date nowTime = new Date();
        if (nowTime.getTime() > endTime.getTime() || nowTime.getTime() < startTime.getTime()) {
            return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }
        //加入特定字符串，不可逆。
        String md5 = getMD5(seckillId);
        return new Exposer(true, md5, seckillId);
    }




    /**
     * 使用注解控制事务方法的优点：
     *      1：明确标注事务方法的编程风格。
     *      2：保证事务方法的执行时间尽可能短，不要穿插其他的网路操作，HTTP请求，RPC请求。或者把网络操作剥离到事务外部。
     *      3：不是所有的方法都需要事务，只有一条修改操作，只读操作不需要事务的控制。
     *
     */
    @Transactional
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException, RepeatKillException, SeckillCloseException {
        if (md5 == null || !md5.equals(getMD5(seckillId))) {
            throw new SeckillException("Seckill date rewrite");
        }
        //执行秒杀逻辑：减库存加购买记录
        Date nowTime = new Date();
        /*
        这里把减库存和记录购买行为调换了位置，
        本来应该是先减少库存，再去记录购买行为。
        但是这样子，每次都下减少库存后，再判断是否重复秒杀，再记录购买行为
        这样子多了一步，我们优化mysql，先去判断是否重复秒杀，再去减库存，优化了一点。
         */
        try {
            //记录购买行为
            int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
            if (insertCount <= 0) {
                //重复秒杀
                throw new RepeatKillException("seckill is repeated");

            } else {
                //减库存
                int updateCount = seckillDao.reduceCount(seckillId, nowTime);
                if (updateCount <= 0) {
                    //没有更新到记录，秒杀结束
                    throw new SeckillCloseException("seckill is closed");
                //唯一：seckillId,userPhone
                } else {
                    //秒杀成功
                    SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
                    return new SeckillExecution(seckillId,SeckillStatEnum.SUCCESS,successKilled);
                }
            }
        } catch (SeckillCloseException e1) {
            throw e1;
        } catch (SeckillException e2) {
            throw e2;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            //所有编译期的异常转化为运行期异常。
            throw new SeckillException("seckill inner error:" + e.getMessage());
        }
    }

    //使用存储过程的秒杀逻辑
    public SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5) {
        if(md5==null||!md5.equals(getMD5(seckillId))){
            return new SeckillExecution(seckillId,SeckillStatEnum.DATA_REWRITE);
        }
        Date killTime = new Date();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("seckillId",seckillId);
        map.put("phone",userPhone);
        map.put("killTime",killTime);
        map.put("result",null);
        try {
            seckillDao.killByProcedure(map);
            //获取result
            int result = MapUtils.getInteger(map,"result",-2);
            if (result==1){
                SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId,userPhone);
                return new SeckillExecution(seckillId,SeckillStatEnum.SUCCESS,successKilled);
            } else {
                return new SeckillExecution(seckillId,SeckillStatEnum.stateOf(result));
            }
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            return new SeckillExecution(seckillId,SeckillStatEnum.INNER_ERROR);
        }
    }
}
