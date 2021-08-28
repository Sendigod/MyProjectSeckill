package com.sorrymaker.seckill.dao;

import com.sorrymaker.seckill.entity.Seckill;
import com.sorrymaker.seckill.entity.SuccessKilled;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @Author nextGame
 * @Date 2021/8/4 21:22
 * @Version 1.0
 */
public interface SuccessKilledDao {

    /**
     * 插入购买明细，可以过滤掉重复
     * @param seckillId
     * @param userPhone
     * @return 插入的行数， 返回0 插入失败
     */
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);


    /**
     * 根据id查询SuccessKilled并携带秒杀产品对象实体
     * @param seckillId
     * @param userPhone
     * @return
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long  userPhone);
}
