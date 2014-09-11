package com.miles.wechat.core;

/**
 * token的获取策略
 *
 * @author miles
 * @datetime 2014/7/7 15:54
 */
public interface TokenPolicy {
    String[] getTokens();
}
