package com.miles.wechat.api;

/**
 * 微信授权获取用户信息的接口
 *
 * @author Michael
 */
public interface AuthorizeService {

    /**
     * 静默授权
     * <p>对于微信页面，已经关注的用户可以使用静默授权，直接获取信息</p>
     */
    void auto();

    /**
     * 对于未关注的用户访问指定的url，而又
     */
    void confirm();
}
