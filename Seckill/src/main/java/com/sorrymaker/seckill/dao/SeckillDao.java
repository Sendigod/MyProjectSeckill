package com.sorrymaker.seckill.dao;

import com.sorrymaker.seckill.entity.Seckill;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

/**
 * @Author nextGame
 * @Date 2021/8/4 19:49
 * @Version 1.0
 */
public interface SeckillDao {

    /**
     * 减库存
     * @param seckillId
     * @param killTime
     * @return 如果影响行数>1 表示更新的记录行数
     */
    int reduceCount(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     * 根据seckillId查询商品
     * @param seckillId
     * @returnq
     */
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量和限制查询商品列表。
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);


}
