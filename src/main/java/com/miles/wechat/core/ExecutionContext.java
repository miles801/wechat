package com.miles.wechat.core;

import com.miles.wechat.api.WechatAccount;

/**
 * @author Michael
 */
public class ExecutionContext {
    private ThreadLocal<WechatAccount> current = new ThreadLocal<WechatAccount>();


}
