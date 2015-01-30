package com.miles.wechat.impl;

import com.miles.cache.CacheContainer;
import com.miles.wechat.api.AuthService;
import com.miles.wechat.api.WechatAccount;
import com.miles.wechat.core.CacheAccount;
import com.miles.wechat.crypt.SHA1;
import com.miles.wechat.utils.StringUtils;
import org.apache.log4j.Logger;

import java.util.Map;

/**
 * @author miles
 */
public class AuthServiceImpl implements AuthService {
    private static final long MAX_EXPIRE = 10000l;
    private Logger logger = Logger.getLogger(AuthServiceImpl.class);

    @Override
    public boolean signature(String originalId, String signature, String timestamp, String nonce) {
        // 获取Token：根据originalId获得缓存的公众号账户信息，并取出对应的token
        String token = null;
        CacheContainer container = CacheContainer.getInstance();
        Map<String, Object> cachedAccount = container.getCachedData(CacheAccount.class);
        if (cachedAccount == null || cachedAccount.isEmpty()) {
            logger.error("未获取到缓存的公众号信息...");
            return false;
        }
        if (StringUtils.isNotEmpty(originalId)) {
            WechatAccount account = (WechatAccount) cachedAccount.get(originalId);
            if (account == null) {
                logger.error("原始ID为[" + originalId + "]的公众号未被缓存!");
                return false;
            }
            token = account.getToken();
        } else {
            if (cachedAccount.size() > 1) {
                logger.error("在系统中发现多个被缓存的公众号,请求中并未指定需要使用的公众号原始ID，无法辨别!");
                return false;
            }
            // 获得唯一的账户
            WechatAccount account = (WechatAccount) cachedAccount.entrySet().iterator().next().getValue();
            token = account.getToken();
        }
        if (StringUtils.isEmpty(token)) {
            throw new SecurityException("没有获得微信的token!");
        }
        if (StringUtils.isEmpty(signature) || StringUtils.isEmpty(timestamp) || StringUtils.isEmpty(nonce)) {
            throw new IllegalArgumentException("微信接口认证时缺少参数!");
        }
        return verify(token, signature, timestamp, nonce);
    }

    private boolean verify(String token, String signature, String timestamp, String nonce) {
        /*Long serverTime = Long.parseLong(timestamp);
        if (new Date().getTime() - serverTime > MAX_EXPIRE) {
            throw new SecurityException("请求的发起时间与当前时间间隔过大，怀疑为恶意校验!");
        }*/
        String securityCode = SHA1.getSHA1(token, timestamp, nonce, "");
        return securityCode.equals(signature);
    }
}
