package com.miles.wechat.api;

import com.miles.wechat.constant.Language;
import com.miles.wechat.entity.Fans;
import com.miles.wechat.entity.FansData;

/**
 * @author miles
 * @datetime 2014/5/21 1:51
 */
public interface FansService {
    /**
     * 获得粉丝列表
     *
     * @param nexOpenId 下一个粉丝的openId，用于分批查询（为空的话表示查询前10000条）
     * @return openId集合
     */
    FansData fansList(String nexOpenId);

    Fans getFansInfo(String openId);

    Fans getFansInfo(String openId, Language language);
}
