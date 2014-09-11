package com.miles.wechat.core;

import com.google.gson.annotations.SerializedName;

/**
 * 请求微信后返回的错误信息
 *
 * @author miles
 * @datetime 2014/5/21 17:04
 */
public class RequestError {
    @SerializedName("errcode")
    private Integer errorCode;
    @SerializedName("errmsg")
    private String errorMsg;

    public RequestError() {
    }

    public RequestError(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
