package com.miles.wechat.core;

import com.miles.cache.Cache;
import com.miles.wechat.api.WechatAccount;

/**
 * 账号缓存池，缓存账号的信息
 * 将其注册到CacheContainer中即可实现数据缓存的效果
 * 该接口必须实现
 *
 * @author Michael
 */
public interface CacheAccount extends Cache<WechatAccount> {

}
