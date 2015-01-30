package com.miles.wechat.message.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * 消息的基类
 *
 * @author miles
 */
public abstract class AbstractMessage {
    /**
     * 消息接收人
     */
    private String toUserName;
    /**
     * 消息发送人
     */
    private String fromUserName;
    /**
     * 消息的发送时间
     */
    private long createTime;
    /**
     * 消息类型
     */
    private String messageType;
    /**
     * 消息ID
     */
    private String messageId;

    @XmlElement(name = "ToUserName")
    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    @XmlElement(name = "FromUserName")
    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    @XmlElement(name = "CreateTime")
    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    @XmlElement(name = "MsgType")
    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    @XmlElement(name = "MsgId")
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }


}
