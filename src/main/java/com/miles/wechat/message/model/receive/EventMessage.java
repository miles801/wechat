package com.miles.wechat.message.model.receive;

import javax.xml.bind.annotation.XmlElement;

/**
 * 事件消息
 *
 * @author Michael
 */
public abstract class EventMessage extends ReceivedMessage {
    /**
     * 事件消息的类型
     */
    protected String event;

    @XmlElement(name = "Event")
    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
