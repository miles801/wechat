package com.miles.wechat;

import com.miles.wechat.core.ServiceLoader;
import com.miles.wechat.impl.SimpleWeChatContext;

/**
 * 测试的基类，用于初始化
 * Created by Michael on 2014/9/15.
 */
public class AbstractBasicTest {
    static {
        ServiceLoader loader = ServiceLoader.newInstance();
        loader.setWeChatContext(SimpleWeChatContext.getInstance());
    }
}
