package com.miles.wechat.core;


import com.google.gson.Gson;
import com.miles.wechat.api.DeveloperInfo;
import com.miles.wechat.entity.AccessToken;
import com.miles.wechat.exceptions.WeChatConfigException;
import com.miles.wechat.utils.PlaceholderFormat;
import com.miles.wechat.utils.SimpleRequest;
import com.miles.wechat.utils.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * AccessToken的缓存池
 * 由于微信限制获取access_token的次数，所以使用将access_token进行缓存
 *
 * @author miles
 * @datetime 2014/5/4 12:53
 */
public class TokenPool {
    private static final long expire = 1000 * 30;
    private static Map<String, AccessToken> pool = new HashMap<String, AccessToken>();

    private TokenPool() {

    }

    /**
     * 获取access_token
     *
     * @param appId  开发者id
     * @param secret 开发者密码
     * @return access_token
     */
    public static String getAccessToken(String appId, String secret) {
        if (StringUtils.isEmpty(appId) || StringUtils.isEmpty(secret)) {
            throw new IllegalArgumentException("获取access_token时，必须指定appid和secret!");
        }
        AccessToken at = pool.get(appId);
        //如果不存在或者已过期，则重新获取
        if (at == null || new Date().getTime() - at.getExpiresIn() >= expire) {
            pool.remove(appId);
            //发起请求获得新的token
            String tokenUrl = Configuration.getInstance().getProperty("wechat.url.accessToken");
            if (StringUtils.isEmpty(tokenUrl)) {
                throw new WeChatConfigException("没有获得AccessToken的访问地址!或者公众号没有找到!");
            }
            String url = PlaceholderFormat.format(tokenUrl, new String[]{appId, secret});
            String json = SimpleRequest.doGet(url);
            Gson gson = new Gson();
            at = (AccessToken) gson.fromJson(json, AccessToken.class);
            pool.put(appId, at);
        }

        return at.getAccessToken();
    }

    /**
     * 根据公众平台微信号获取access_token
     *
     * @param wcid 微信公众号
     * @return access_token
     */
    public static String getAccessToken(String wcid) {
        if (StringUtils.isEmpty(wcid)) {
            throw new IllegalArgumentException("没有获得微信公众平台公众号!");
        }
        WeChatContext context = WeChatEngine.newInstance().getWeChatContext();
        DeveloperInfo info = context.getDeveloperInfo();
        if (info == null) {
            throw new SecurityException("该公众号不存在或者尚未开通开发者功能!");
        }
        String appId = info.getAppId();
        String secret = info.getSecret();
        return getAccessToken(appId, secret);
    }

}
