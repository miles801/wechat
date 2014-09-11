package com.miles.wechat.api;

/**
 * 多媒体类型
 * Created by miles on 2014/5/6.
 */
public enum MultiMediaType {
    VIDEO("video"),
    IMAGE("image"),
    VOICE("voice"),
    THUMB("thumb");
    private String value;

    private MultiMediaType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
