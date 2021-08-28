package com.sorrymaker.seckill.dao.cache;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.sorrymaker.seckill.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Author nextGame
 * @Date 2021/8/28 21:12
 * @Version 1.0
 */
public class RedisDao {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final JedisPool jedisPool;

    private RuntimeSchema<Seckill> schema = RuntimeSchema.createFrom(Seckill.class);

    public RedisDao(String ip, int port) {
        jedisPool = new JedisPool(ip, port);
    }

    public Seckill getSeckill(long seckillId) {
        //Redis操作逻辑
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "seckillId:" + seckillId;
                //get-->byte[]-->反序列化-->Object（Seckill）
                //这样子写的好处，能比原来序列化更优。采用自定义序列化。
                byte[] bytes = jedis.get(key.getBytes());
                if (bytes != null) {
                    //这里是个空对象
                    Seckill seckill = schema.newMessage();
                    //传递缓存和空对象，如何protostuff根据传进来的字节数组，传入数据给空对象，
                    ProtostuffIOUtil.mergeFrom(bytes, seckill, schema);
                    return seckill;
                }
            } finally {
                jedis.close();
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }

    public String putSeckill(Seckill seckill) {
        //Set Object(seckill)-->序列化 -->byte[]  <<--序列化的过程
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "seckillId:" + seckill.getSeckillId();

                byte[] bytes = ProtostuffIOUtil.toByteArray(seckill, schema,
                        LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                //超时缓存, 这里设置为1个小时
                int timeout = 60 * 60;
                String result = jedis.setex(key.getBytes(), timeout, bytes);
                return result;
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

}

