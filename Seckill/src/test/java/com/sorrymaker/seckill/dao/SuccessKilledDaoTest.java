package com.sorrymaker.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.sorrymaker.seckill.entity.SuccessKilled;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @Author nextGame
 * @Date 2021/7/26 21:09
 * @Version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
//告诉Juit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() {
        //这里可以过滤重复，因为联合主键了，当id或者phone重复，insert ignore，设置这个，不让主键冲突异常，
        long id =1012L;
        long phone=123456789101L;
        int insertCount = successKilledDao.insertSuccessKilled(id, phone);
        System.out.println("insertCount=" + insertCount);
    }

    @Test
    public void queryByIdWithSeckill() {
        long id =1012L;
        long phone=123456789101L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id, phone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }
}