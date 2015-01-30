package com.miles.wechat.exceptions;

/**
 * 无效的消息异常
 *
 * @author Michael
 */
public class WeChatMessageException extends Exception {
    public WeChatMessageException() {
        super();
    }

    public WeChatMessageException(String message) {
        super(message);
    }

    public WeChatMessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeChatMessageException(Throwable cause) {
        super(cause);
    }
}
