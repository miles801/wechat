package com.miles.wechat.core;

import com.google.gson.Gson;
import com.miles.wechat.api.DeveloperInfo;
import com.miles.wechat.api.ResponseInfo;
import com.miles.wechat.entity.GlobalCode;
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
        WeChatEngine engine = WeChatEngine.newInstance();
        DeveloperInfo developerInfo = engine.getWeChatContext().getDeveloperInfo();
        if (developerInfo == null) {
            throw new SecurityException("该公众号还没有成为开发者!");
        }
        String accessToken = TokenPool.getAccessToken(developerInfo.getAppId(), developerInfo.getSecret());
        if (StringUtils.isEmpty(accessToken)) {
            throw new SecurityException("没有获得accessToken!");
        }
        int length = (extraData == null || extraData.length == 0) ? 0 : extraData.length;
        Serializable[] params = new Serializable[length + 1];
        params[0] = accessToken;
        if (length > 0) {
            System.arraycopy(extraData, 0, params, 1, length);
        }
        return PlaceholderFormat.format(url, params);
    }

    /**
     * 根据响应信息字符串转换成对应的响应信息对象
     *
     * @param result 访问微信后返回的响应json字符串
     * @return ResponseInfo
     */
    public static ResponseInfo getResponseInfo(String result) {
        Gson gson = new Gson();
        final GlobalCode code = gson.fromJson(result, GlobalCode.class);
        return new ResponseInfo() {
            @Override
            public boolean isSuccess() {
                return code == null || code.getErrorCode() == null || code.getErrorCode() == 0;
            }

            @Override
            public GlobalCode getInfo() {
                return code;
            }
        };
    }
}
