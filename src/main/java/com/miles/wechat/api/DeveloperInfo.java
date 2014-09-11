package com.miles.wechat.api;

/**
 * 微信公众平台开发者信息接口
 *
 * @author miles
 * @datetime 2014/5/15 12:03
 */
public interface DeveloperInfo {

    String getToken();

    String getAppId();

    String getSecret();
}
