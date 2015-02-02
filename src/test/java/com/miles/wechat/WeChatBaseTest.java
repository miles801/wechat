package com.miles.wechat;

import com.miles.wechat.core.PublicServiceLoader;
import com.miles.wechat.core.WeChatContext;
import com.miles.wechat.core.WeChatEngine;
import com.miles.wechat.impl.SimpleCacheAccount;

/**
 * 微信测试的基类，用于初始化相关服务
 * Created by Michael on 2014/9/15.
 */
public class WeChatBaseTest {
    static {
        // 实例化公共接口服务
        PublicServiceLoader publicServiceLoader = PublicServiceLoader.getInstance();
        // 设置缓存的公众号
        publicServiceLoader.setCacheAccount(new SimpleCacheAccount());

        // 初始化引擎
        WeChatEngine.newInstance();

        // 设置为万达的公众号
        WeChatContext.set("gh_36f3110ed079");
    }
}
