package com.miles.wechat.impl;

import com.google.gson.*;
import com.miles.wechat.api.FansService;
import com.miles.wechat.api.ResponseInfo;
import com.miles.wechat.api.WeChatUrl;
import com.miles.wechat.constant.Language;
import com.miles.wechat.core.RequestError;
import com.miles.wechat.core.RequestException;
import com.miles.wechat.core.RequestWrapper;
import com.miles.wechat.entity.Fans;
import com.miles.wechat.entity.FansData;
import com.miles.wechat.utils.SimpleRequest;
import com.miles.wechat.utils.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author miles
 * @datetime 2014/5/21 17:26
 */
public class FansServiceImpl implements FansService {
    @Override
    public FansData fansList(String nexOpenId) {
        String url = RequestWrapper.getUrl(WeChatUrl.FANS_LIST, nexOpenId);
        url += "&groupid=0";
        String result = SimpleRequest.doGet(url);
        ResponseInfo info = RequestWrapper.getResponseInfo(result);
        if (!info.isSuccess()) {
            throw new RequestException(new RequestError(info.getErrorCode(), info.getErrorMessage()));
        }
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        JsonObject jsonObject = gson.fromJson(result, JsonObject.class);
        int total = jsonObject.get("total").getAsInt();
        int count = jsonObject.get("count").getAsInt();
        JsonObject data = jsonObject.get("data").getAsJsonObject();
        JsonArray array = data.getAsJsonArray("openid");
        List<String> arr = new ArrayList<String>();
        Iterator<JsonElement> iterator = array.iterator();
        while (iterator.hasNext()) {
            JsonElement element = iterator.next();
            arr.add(element.getAsString());
        }
        String nextOpenId = jsonObject.get("next_openid").getAsString();
        FansData fansData = new FansData();
        fansData.setTotal(total);
        fansData.setCount(count);
        fansData.setNextOpenId(nextOpenId);
        fansData.setData(arr);
        return fansData;
    }

    @Override
    public Fans getFansInfo(String openId) {
        return getFansInfo(openId, Language.ZH_CN);
    }

    @Override
    public Fans getFansInfo(String openId, Language language) {
        if (StringUtils.isEmpty(openId)) {
            throw new IllegalArgumentException("获取粉丝信息时，没有指定openId!");
        }
        if (language == null) {
            language = Language.ZH_CN;
        }
        String url = RequestWrapper.getUrl(WeChatUrl.FANS_INFO, openId, language.getValue());
        String result = SimpleRequest.doGet(url);
        ResponseInfo info = RequestWrapper.getResponseInfo(result);
        if (!info.isSuccess()) {
            throw new RequestException(new RequestError(info.getErrorCode(), info.getErrorMessage()));
        }
        Gson gson = new Gson();
        Fans fans = gson.fromJson(result, Fans.class);
        // 时间*1000
        if (fans.getSubscribeTime() != null) {
            fans.setSubscribeTime(fans.getSubscribeTime() * 1000);
        }
        return fans;
    }
}
