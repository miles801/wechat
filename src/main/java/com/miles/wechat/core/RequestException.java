package com.miles.wechat.core;

/**
 * 微信请求异常
 *
 * @author miles
 * @datetime 2014/5/21 17:03
 */
public class RequestException extends RuntimeException {
    private RequestError error;


    public RequestException(RequestError error) {
        super();
        this.error = error;
    }

    public RequestException(RequestError error, String message) {
        super(message);
        this.error = error;
    }

    public RequestException(RequestError error, String message, Throwable cause) {
        super(message, cause);
        this.error = error;
    }

    public RequestError getError() {
        return error;
    }

    public void setError(RequestError error) {
        this.error = error;
    }
}
