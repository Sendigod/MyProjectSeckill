package com.sorrymaker.seckill.service;

import com.sorrymaker.seckill.dto.Exposer;
import com.sorrymaker.seckill.dto.SeckillExecution;
import com.sorrymaker.seckill.entity.Seckill;
import com.sorrymaker.seckill.enums.SeckillStatEnum;
import com.sorrymaker.seckill.exception.RepeatKillException;
import com.sorrymaker.seckill.exception.SeckillCloseException;
import com.sorrymaker.seckill.exception.SeckillException;

import java.util.List;

/**
 * 业务接口：站在“使用者”角度设计接口
 * 三个方面：方法定义粒度、参数、返回类型（return  类型/异常）
 * 应该关注执行秒杀，而不是关注秒杀怎么减库存。使用者怎么友好的使用
 * 方法定义粒度 -->> 把所有方法都应该想到
 * 参数 -->> 越简练越好。
 * @Author nextGame
 * @Date 2021/8/8 16:41
 * @Version 1.0
 */
public interface SeckillService {

    /**
     * 查询所有秒杀记录
     * @return
     */
    List<Seckill> getSeckillList();



    /**
     * 查询单个秒杀记录
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);


    /**
     * 秒杀开始时，输出秒杀接口地址，否则输出系统时间和秒杀时间。
     * @param seckillId
     * @return
     */
    Exposer exportSeckillUrl(long seckillId);


    /**
     * 执行秒杀操作
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
        throws SeckillException, RepeatKillException, SeckillCloseException;
}
