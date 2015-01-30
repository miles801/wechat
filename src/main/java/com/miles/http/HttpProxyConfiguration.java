package com.miles.http;

import com.miles.wechat.utils.StringUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Http代理配置
 * Created by Michael on 2014/9/15.
 */
public class HttpProxyConfiguration {
    private Logger logger = Logger.getLogger(HttpProxyConfiguration.class);
    private static HttpProxyConfiguration config = new HttpProxyConfiguration();
    private boolean isProxy = false;
    private HttpProxy httpProxy = null;

    private HttpProxyConfiguration() {
        Properties properties = new Properties();
        try {
            InputStream inputStream = HttpProxyConfiguration.class.getClassLoader().getResourceAsStream("http.properties");
            if (inputStream != null) {
                properties.load(inputStream);
                String host = properties.getProperty("http.proxy.host");
                String port = properties.getProperty("http.proxy.port");
                if (!StringUtils.isEmpty(host) && !StringUtils.isEmpty(port)) {
                    isProxy = true;
                    HttpProxyImpl proxyImpl = new HttpProxyImpl();
                    proxyImpl.setHost(host);
                    proxyImpl.setPort(Integer.parseInt(port));
                    proxyImpl.setUsername(properties.getProperty("http.proxy.username"));
                    proxyImpl.setPassword(properties.getProperty("http.proxy.password"));
                    String timeout = properties.getProperty("http.proxy.timeout");
                    if (!StringUtils.isEmpty(timeout)) {
                        proxyImpl.setTimeout(Long.parseLong(timeout));
                    }
                    httpProxy = proxyImpl;
                }
            }
        } catch (IOException e) {
            logger.error("加载http.properties文件发生错误!");
            e.printStackTrace();
        }
    }

    public static HttpProxyConfiguration getInstance() {
        return config;
    }

    /**
     * 判断是否是代理
     */
    public boolean isProxy() {
        return isProxy;
    }

    /**
     * 返回代理对象，如果代理没有启用，则返回null
     */

    public HttpProxy getProxy() {
        return httpProxy;
    }
}
