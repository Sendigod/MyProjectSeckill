package com.sorrymaker.seckill.exception;

/**
 * 重复秒杀异常（运行期异常）
 * @Author nextGame
 * @Date 2021/8/8 16:57
 * @Version 1.0
 */
public class RepeatKillException extends SeckillException {

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
