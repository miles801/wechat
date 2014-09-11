package com.miles.wechat.impl;

import com.miles.wechat.api.DeveloperInfo;
import com.miles.wechat.core.Configuration;

/**
 * @author miles
 * @datetime 2014/7/7 15:13
 */
public class SimpleDevelopInfo implements DeveloperInfo {
    private String appId;
    private String secret;
    private String token;

    public SimpleDevelopInfo() {
        Configuration configuration = Configuration.getInstance();
        appId = configuration.getAppId();
        secret = configuration.getSecret();
        token = configuration.getToken();
    }


    @Override
    public String getAppId() {
        return appId;
    }


    @Override
    public String getSecret() {
        return secret;
    }


    @Override
    public String getToken() {
        return token;
    }

}
