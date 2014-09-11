package com.miles.wechat.api;

import com.miles.wechat.entity.GlobalCode;

/**
 * 请求微信后的响应接口
 *
 * @author miles
 * @datetime 2014/5/21 2:07
 */
public interface ResponseInfo {

    boolean isSuccess();

    GlobalCode getInfo();
}
