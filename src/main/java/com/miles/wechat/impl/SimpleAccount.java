package com.miles.wechat.impl;

import com.miles.wechat.api.WechatAccount;
import com.miles.wechat.core.Configuration;

/**
 * @author miles
 * @datetime 2014/7/7 15:13
 */
public class SimpleAccount implements WechatAccount {
    private String appId;
    private String secret;
    private String token;

    public SimpleAccount() {
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

    @Override
    public String getEncryptKey() {
        return null;
    }

    @Override
    public String getEncryptType() {
        return WechatAccount.ENCRYPT_NO;
    }

    @Override
    public String getOriginalId() {
        return null;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
