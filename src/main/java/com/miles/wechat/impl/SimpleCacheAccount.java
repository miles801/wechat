package com.miles.wechat.impl;

import com.miles.wechat.api.WechatAccount;
import com.miles.wechat.core.CacheAccount;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael
 */
public class SimpleCacheAccount implements CacheAccount {
    @Override
    public Map<String, WechatAccount> load() {
        Map<String, WechatAccount> map = new HashMap<String, WechatAccount>();
        SimpleAccount account = new SimpleAccount();
        account.setAppId("wx9e74795487499c3b");
        account.setSecret("38ea56d7a4a1f73f38874b844c2d96dd");
        account.setToken("wanda");
        account.setOriginalId("gh_36f3110ed079");
        map.put(account.getOriginalId(), account);
        return map;
    }

    @Override
    public long getTimeout() {
        return 10 * 60 * 1000;
    }

    @Override
    public void doWhileTimeout() {

    }
}
