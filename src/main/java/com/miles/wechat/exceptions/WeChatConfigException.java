package com.miles.wechat.exceptions;

/**
 * 微信配置异常
 * Created by Michael on 2014/9/15.
 */
public class WeChatConfigException extends WeChatException {
    public WeChatConfigException() {
        super();
    }

    public WeChatConfigException(String message) {
        super(message);
    }

    public WeChatConfigException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeChatConfigException(Throwable cause) {
        super(cause);
    }

}
