package com.miles.wechat.exceptions;

/**
 * 微信相关异常
 * Created by Michael on 2014/9/15.
 */
public class WeChatException extends RuntimeException {
    public WeChatException() {
        super();
    }

    public WeChatException(String message) {
        super(message);
    }

    public WeChatException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeChatException(Throwable cause) {
        super(cause);
    }

}
