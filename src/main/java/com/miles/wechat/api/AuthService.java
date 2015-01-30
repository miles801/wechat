package com.miles.wechat.api;

/**
 * 微信的验证接口
 * <p>用于验证消息是否合法</p>
 *
 * @author michael
 */
public interface AuthService {

    /**
     * 微信接口认证:用于判断接收到的消息是否是来自微信
     * 返回认证结果：true，认证成功，false，认证失败
     *
     * @param originalId 微信公众号ID(可以为空，如果为空则表示选取唯一的公众号）
     * @param signature  加密串（最终需要比对的结果）
     * @param timestamp  时间戳
     * @param nonce      随机数
     * @return true/false
     */
    public boolean signature(String originalId, String signature, String timestamp, String nonce);

}
