package com.miles.wechat.core;

import com.miles.wechat.api.DeveloperInfo;

/**
 * 微信信息接口
 * 所有的微信接口直接使用该接口获取信息，具体的获取方式由该接口的实现来决定
 * 可以通过配置的方式获得，也可以通过数据库的方式获得（根据实现决定）
 *
 * @author miles
 * @datetime 2014/5/21 2:57
 */
public interface WeChatContext {

    /**
     * 获取微信公众号：原始账号
     *
     * @return 微信公众号
     */
    String getAccount();

    /**
     * 获取开发者信息
     *
     * @return 开发者信息
     */
    DeveloperInfo getDeveloperInfo();
}
