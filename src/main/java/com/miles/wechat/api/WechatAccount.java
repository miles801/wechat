package com.miles.wechat.api;

/**
 * 微信公众平台账号
 *
 * @author miles
 */
public interface WechatAccount {

    /**
     * 加密方式：无，明文
     */
    public static final String ENCRYPT_NO = "NO";
    /**
     * 加密方式：安全模式，使用EncodingEASKey加密
     */
    public static final String ENCRYPT_SECURITY = "SECURITY";

    /**
     * 加密方式：兼容，即可使用明文，也可使用安全模式
     */
    public static final String ENCRYPT_BOTH = "BOTH";

    /**
     * 获得用户指定的Token，在对消息进行验证时需要用到
     *
     * @since 2.0
     */
    String getToken();

    /**
     * 微信公众号的原始ID
     *
     * @since 2.0
     */
    String getOriginalId();

    /**
     * 开发者ID（微信提供）
     */
    String getAppId();

    /**
     * 开发者密钥（微信提供）
     */
    String getSecret();

    /**
     * 获得加密类型，值的类型参考当前接口的常量
     * <p>类型的值为：明文模式、安全模式、混合模式</p>
     *
     * @since 2.0
     */
    String getEncryptType();

    /**
     * 获得EAS加密的key
     * 只有当使用的是
     *
     * @since 2.0
     */
    String getEncryptKey();
}
