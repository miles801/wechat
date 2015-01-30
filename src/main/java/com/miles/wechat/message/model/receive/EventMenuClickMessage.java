package com.miles.wechat.message.model.receive;

import com.miles.wechat.message.enums.EventMessageType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 点击菜单的事件消息
 * <p>一般用于点击菜单时，根据配置的eventKey获取拉取对应的消息</p>
 *
 * @author Michael
 */
@XmlRootElement(name = "xml")
public class EventMenuClickMessage extends EventMessage {
    /**
     * 事件KEY值，与自定义菜单接口中KEY值对应
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
        return EventMessageType.MENU_CLICK.getValue();
    }
}
