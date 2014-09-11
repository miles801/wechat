package com.miles.wechat.api;

/**
 * 微信的基础服务
 *
 * @author miles
 * @datetime 2014/5/21 1:34
 */
public interface BasicService {

    /**
     * 微信接口认证:根据TokenPolicy获取token列表，依次遍历判断是否拥有适合的接口
     * 参数必须，否则会抛出无效的参数异常!
     *
     * @param signature 加密串
     * @param timestamp 时间戳
     * @param nonce     随机数
     * @return true/false
     */
    public boolean signature(String signature, String timestamp, String nonce);

}
