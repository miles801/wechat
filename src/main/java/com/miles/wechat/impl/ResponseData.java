package com.miles.wechat.impl;

import com.miles.wechat.api.ResponseInfo;

/**
 * @author Michael
 */
public class ResponseData implements ResponseInfo {
    private boolean isSuccess;
    private Integer errorCode;
    private String errorMessage;
    /**
     * 消息ID
     */
    private String messageId;

    @Override
    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    @Override
    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
