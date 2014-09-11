package com.miles.wechat.api;

/**
 * 消息类型
 * Created by miles on 2014/5/21.
 */
public enum MessageType {
    NEWS("news"),
    TEXT("text"),
    IMAGE("image"),
    VOICE("voice"),
    VIDEO("video"),
    LOCATION("location"),
    LINK("link"),
    EVENT("event");

    private String value;

    private MessageType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
