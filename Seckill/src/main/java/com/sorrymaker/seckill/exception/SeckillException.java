package com.sorrymaker.seckill.exception;

/**
 * 秒杀相关异常
 * @Author nextGame
 * @Date 2021/8/8 16:59
 * @Version 1.0
 */
public class SeckillException extends RuntimeException {
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
