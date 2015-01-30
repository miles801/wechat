package com.miles.wechat.message.model.receive;

import com.miles.wechat.message.model.AbstractMessage;

import javax.xml.bind.annotation.XmlTransient;

/**
 * 接收到的消息的基类
 *
 * @author Michael
 */
public abstract class ReceivedMessage extends AbstractMessage {
    /**
     * 真正的消息对象类
     */
    private Class<? extends ReceivedMessage> realClass;
    /**
     * 是否为事件类型
     */
    private boolean isEvent;

    /**
     * 事件类型：只有当isEvent=true时该值才存在
     */
    private String eventType;

    @XmlTransient
    /**
     * 获得真实的消息类类型
     */
    public Class<? extends ReceivedMessage> getRealClass() {
        return realClass;
    }

    public void setRealClass(Class<? extends ReceivedMessage> realClass) {
        this.realClass = realClass;
    }

    @XmlTransient
    public boolean isEvent() {
        return isEvent;
    }

    public void setEvent(boolean isEvent) {
        this.isEvent = isEvent;
    }

    @XmlTransient
    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}
