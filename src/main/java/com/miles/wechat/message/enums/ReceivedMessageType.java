package com.miles.wechat.message.enums;

/**
 * 接收到的消息的类型
 * Created by miles on 2014/5/21.
 */
public enum ReceivedMessageType {
    /**
     * 文本
     */
    TEXT("text"),
    /**
     * 图片
     */
    IMAGE("image"),
    /**
     * 音频
     */
    VOICE("voice"),
    /**
     * 视频
     */
    VIDEO("video"),
    /**
     * 地理位置
     */
    LOCATION("location"),
    /**
     * 链接
     */
    LINK("link"),
    /**
     * 事件消息
     */
    EVENT("event");

    private String value;

    private ReceivedMessageType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
