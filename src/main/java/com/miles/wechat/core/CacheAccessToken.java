package com.miles.wechat.core;

import com.google.gson.Gson;
import com.miles.cache.Cache;
import com.miles.cache.CacheContainer;
import com.miles.wechat.api.WechatAccount;
import com.miles.wechat.entity.AccessToken;
import com.miles.wechat.exceptions.WeChatConfigException;
import com.miles.wechat.utils.PlaceholderFormat;
import com.miles.wechat.utils.SimpleRequest;
import com.miles.wechat.utils.StringUtils;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael
 */
public class CacheAccessToken implements Cache<String> {
    private Logger logger = Logger.getLogger(CacheAccessToken.class);

    @Override
    public Map<String, String> load() {
        Map<String, String> accessTokenMap = new HashMap<String, String>();
        // 获取所有的公众号
        CacheContainer cacheContainer = CacheContainer.getInstance();
        Map<String, Object> accountMap = cacheContainer.getCachedData(CacheAccount.class);

        if (accountMap == null || accountMap.isEmpty()) {
            logger.error("微信公众号账号池为空!");
            return accessTokenMap;
        }
        // 遍历公众号加载AccessToken
        for (Map.Entry<String, Object> entry : accountMap.entrySet()) {
            WechatAccount account = (WechatAccount) entry.getValue();
            String originalId = entry.getKey();
            String appId = account.getAppId();
            String appSecret = account.getSecret();
            AccessToken accessToken = loadAccessToken(appId, appSecret);
            if (accessToken == null) {
                logger.error("公众号[" + originalId + "]获取AccessToken时失败!");
                continue;
            }
            // 获得accessToken
            accessTokenMap.put(originalId, accessToken.getAccessToken());
        }
        return accessTokenMap;
    }

    @Override
    public long getTimeout() {
        // 1.5小时后过期
        return 90 * 60 * 1000;
    }

    @Override
    public void doWhileTimeout() {
        // 当过期后，重新加载AccessToken
        CacheContainer.getInstance().reload(CacheAccessToken.class);
    }

    /**
     * 加载AccessToken
     *
     * @param appId  appId
     * @param secret appSecret
     */
    private AccessToken loadAccessToken(String appId, String secret) {
        //发起请求获得新的token
        String tokenUrl = Configuration.getInstance().getProperty("wechat.url.accessToken");
        if (StringUtils.isEmpty(tokenUrl)) {
            throw new WeChatConfigException("没有获得AccessToken的访问地址!或者公众号没有找到!");
        }
        String url = PlaceholderFormat.format(tokenUrl, new Serializable[]{appId, secret});
        String json = SimpleRequest.doGet(url);
        Gson gson = new Gson();
        AccessToken at = (AccessToken) gson.fromJson(json, AccessToken.class);
        return at;
    }
}
