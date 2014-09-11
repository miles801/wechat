package com.miles.wechat.core;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 微信配置：从wechat.properties文件中读取微信的配置信息，并初始化变量
 *
 * @author miles
 * @datetime 2014/7/7 16:01
 */
public class Configuration {
    private static Configuration configuration = new Configuration();
    Properties properties;
    private String appId;
    private String secret;
    private String token;

    private Configuration() {
        InputStream in = Configuration.class.getClassLoader().getResourceAsStream("wechat.properties");
        if (in != null) {
            try {
                properties = new Properties();
                properties.load(in);
                appId = properties.getProperty("wechat.appid");
                secret = properties.getProperty("wechat.secret");
                token = properties.getProperty("wechat.tokens");
            } catch (IOException e) {
                Logger logger = Logger.getLogger(Configuration.class);
                logger.info("没有找到微信的配置文件[wechat.properties],使用默认值!");
            }

        }
    }

    public static Configuration getInstance() {
        return configuration;
    }

    public String getAppId() {
        return appId;
    }

    public String getSecret() {
        return secret;
    }

    public String getToken() {
        return token;
    }
}
