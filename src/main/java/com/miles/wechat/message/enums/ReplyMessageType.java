package com.miles.wechat.message.enums;

/**
 * 用于被动回复消息时的消息类型
 *
 * @author Michael
 */
public enum ReplyMessageType {
    /**
     * 文本消息
     */
    TEXT("text"),
    /**
     * 图片消息
     */
    IMAGE("image"),
    /**
     * 语音消息
     */
    VOICE("voice"),
    /**
     * 视频消息
     */
    VIDEO("video"),
    /**
     * 音乐消息
     */
    MUSIC("music"),
    /**
     * 图文消息
     */
    NEWS("news");
    private String value;

    private ReplyMessageType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
