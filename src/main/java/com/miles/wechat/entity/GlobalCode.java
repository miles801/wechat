package com.miles.wechat.entity;

import com.google.gson.annotations.SerializedName;

/**
 * @author miles
 * @datetime 2014/5/6 15:41
 */
public class GlobalCode {
    @SerializedName("errcode")
    private Integer errorCode;
    @SerializedName("errmsg")
    private String errorMessage;
    @SerializedName("msg_id")
    private String msgId;

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
