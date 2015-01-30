package com.miles.wechat.message.model.receive;

import com.miles.wechat.message.enums.EventMessageType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 点击链接菜单的事件消息
 *
 * @author Michael
 */
@XmlRootElement(name = "xml")
public class EventMenuLinkMessage extends EventMessage {
    /**
     * 事件KEY值，设置的跳转URL
     */
    private String eventKey;

    @XmlElement(name = "EventKey")
    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    @Override
    public String getEvent() {
        return EventMessageType.MENU_LINK.getValue();
    }
}
