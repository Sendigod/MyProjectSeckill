package com.sorrymaker.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.sorrymaker.seckill.entity.Seckill;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;

/**
 * @Author nextGame
 * @Date 2021/7/25 23:21
 * @Version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
//告诉Juit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {


    //注入Dao实现类依赖
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void reduceNumber() {
        Date killTime = new Date();
        int updateCount = seckillDao.reduceCount(1012L, killTime);
        System.out.println("updateCount="+updateCount) ;
    }

    @Test
    public void queryById() {
        long id =1012;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    @Test
    public void queryAll() {
        List<Seckill> seckills =seckillDao.queryAll(0,100);
        for(Seckill seckill:seckills){
            System.out.println(seckill);
        }
    }
}