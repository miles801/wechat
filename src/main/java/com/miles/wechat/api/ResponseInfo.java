package com.miles.wechat.api;

/**
 * 请求微信后的响应接口
 *
 * @author miles
 * @datetime 2014/5/21 2:07
 */
public interface ResponseInfo {

    boolean isSuccess();

    /**
     * 获得错误码
     */
    Integer getErrorCode();

    /**
     * 获得错误的描述信息
     */
    String getErrorMessage();

    /**
     * 获得出错的消息的id
     */
    String getMessageId();
}
