package com.miles.http;

/**
 * Http代理配置
 * Created by Michael on 2014/9/15.
 */
public class HttpProxyConfiguration {
    public static HttpProxyConfiguration getInstance() {
        return config;
    }

    private HttpProxyConfiguration() {
    }

    private static HttpProxyConfiguration config = new HttpProxyConfiguration();
}
