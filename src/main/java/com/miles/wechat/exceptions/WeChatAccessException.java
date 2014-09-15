package com.miles.wechat.exceptions;

/**
 * 微信访问异常
 * Created by Michael on 2014/9/15.
 */
public class WeChatAccessException extends WeChatException{
    public WeChatAccessException() {
        super();
    }

    public WeChatAccessException(String message) {
        super(message);
    }

    public WeChatAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeChatAccessException(Throwable cause) {
        super(cause);
    }

    protected WeChatAccessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
