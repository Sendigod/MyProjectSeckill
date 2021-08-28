package com.sorrymaker.seckill.service;

import com.sorrymaker.seckill.dto.Exposer;
import com.sorrymaker.seckill.dto.SeckillExecution;
import com.sorrymaker.seckill.entity.Seckill;
import org.apache.ibatis.javassist.ClassPath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author nextGame
 * @Date 2021/8/9 22:20
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
                        "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}",list);
    }


    @Test
    public void getById() {
        long id = 1000;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}",seckill);
    }

    @Test
    public void exportSeckillUrl() {
        long id = 1006;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        logger.info("exposer={}",exposer);
    }

    @Test
    public void executeSeckill() {
        long id = 1006;
        long phone = 12345678910L;
        String md5 ="d19dbc5b74fefa9ece03aee35821f89d";
        SeckillExecution execution = seckillService.executeSeckill(id, phone, md5);
        logger.info("result={}",execution);
    }

    @Test
    public void executeSeckillProcedure() {
            long seckillId = 1014;
            long phone = 15694332288L;
            Exposer exposer = seckillService.exportSeckillUrl(seckillId);
            if(exposer.isExposed()){
                String md5 = exposer.getMd5();
                SeckillExecution execution = seckillService.executeSeckillProcedure(seckillId,phone,md5);
                logger.info(execution.getStateInfo());
        }
    }
}