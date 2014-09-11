package com.miles.wechat.impl;

import com.miles.wechat.api.DeveloperInfo;
import com.miles.wechat.core.Configuration;
import com.miles.wechat.core.WeChatContext;

/**
 * 微信信息的简单实现，直接指定了要返回的值
 *
 * @author miles
 * @datetime 2014/5/21 3:10
 */
public class SimpleWeChatContext implements WeChatContext {
    private static SimpleWeChatContext context = new SimpleWeChatContext();
    private String account = "ulane_com";
    private String appid = "wxf91fe4dc94dcbb71";
    private String secret = "a4cbf5a8d14449ba4b50ef9f697b05d3";
    private Configuration configuration = null;

    private SimpleWeChatContext() {
        configuration = Configuration.getInstance();
        appid = configuration.getAppId();
        secret = configuration.getSecret();
    }

    public static SimpleWeChatContext getInstance() {
        return context;
    }

    @Override
    public String getAccount() {
        return account;
    }

    @Override
    public DeveloperInfo getDeveloperInfo() {
        return (DeveloperInfo) new SimpleDevelopInfo();
    }
}
