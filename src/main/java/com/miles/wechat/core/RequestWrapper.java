package com.miles.wechat.core;

import com.google.gson.Gson;
import com.miles.cache.CacheContainer;
import com.miles.wechat.api.ResponseInfo;
import com.miles.wechat.api.WechatAccount;
import com.miles.wechat.entity.GlobalCode;
import com.miles.wechat.exceptions.WeChatConfigException;
import com.miles.wechat.impl.ResponseData;
import com.miles.wechat.utils.PlaceholderFormat;
import com.miles.wechat.utils.StringUtils;

import java.io.Serializable;

/**
 * @author miles
 * @datetime 2014/5/21 2:23
 */
public class RequestWrapper {

    /**
     * 根据微信号和url获取解释过后的url（去掉占位符）
     *
     * @param url WeChatUrl中的常量
     * @return 新的url
     */
    public static String getUrl(String url, Serializable... extraData) {
        WechatAccount wechatAccount = (WechatAccount) CacheContainer.getInstance()
                .getCachedData(CacheAccount.class)
                .get(WeChatContext.get());
        if (wechatAccount == null) {
            throw new SecurityException("公众号[" + WeChatContext.get() + "]还没有成为开发者或者没有被加载!");
        }
        String accessToken = (String) CacheContainer.getInstance()
                .getCachedData(CacheAccessToken.class)
                .get(wechatAccount.getOriginalId());
//        String accessToken = TokenPool.getAccessToken(wechatAccount.getAppId(), wechatAccount.getSecret());
        if (StringUtils.isEmpty(accessToken)) {
            throw new SecurityException("没有获得accessToken!");
        }
        int length = (extraData == null || extraData.length == 0) ? 0 : extraData.length;
        Serializable[] params = new Serializable[length + 1];
        params[0] = accessToken;
        Configuration configuration = Configuration.getInstance();
        String configUrl = configuration.getProperty(url);
        if (StringUtils.isEmpty(configUrl)) {
            throw new WeChatConfigException((new StringBuilder()).append("\u6CA1\u6709\u83B7\u5F97\u5C5E\u6027\u503C\u4E3A[").append(url).append("]\u7684\u5FAE\u4FE1\u8BBF\u95EE\u5730\u5740!").toString());
        }
        if (length > 0) {
            System.arraycopy(extraData, 0, params, 1, length);
        }
        return PlaceholderFormat.format(configUrl, params);
    }

    /**
     * 根据响应信息字符串转换成对应的响应信息对象
     *
     * @param result 访问微信后返回的响应json字符串
     * @return ResponseInfo
     */
    public static ResponseInfo getResponseInfo(String result) {
        Gson gson = new Gson();
        GlobalCode code = gson.fromJson(result, GlobalCode.class);
        ResponseData data = new ResponseData();
        data.setMessageId(code.getMsgId());
        data.setErrorCode(code.getErrorCode());
        data.setErrorMessage(code.getErrorMessage());
        // 0表示正确
        if (code.getErrorCode() == null || code.getErrorCode() == 0) {
            data.setSuccess(true);
        }
        return data;
    }
}
