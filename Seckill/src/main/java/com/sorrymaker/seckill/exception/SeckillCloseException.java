package com.sorrymaker.seckill.exception;

/**
 * 秒杀关闭异常
 * @Author nextGame
 * @Date 2021/8/8 16:58
 * @Version 1.0
 */
public class SeckillCloseException extends SeckillException{
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
