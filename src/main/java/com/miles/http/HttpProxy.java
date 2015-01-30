package com.miles.http;

/**
 * Http代理
 * Created by Michael on 2014/9/15.
 */
public interface HttpProxy {

    /**
     * 获取代理主机地址
     */
    String getHost();

    /**
     * 代理端口
     */
    int getPort();

    /**
     * 用户名
     */
    String getUsername();

    /**
     * 密码
     */
    String getPassword();

    /**
     * 超时时间
     */
    long getTimeout();
}
