package com.miles.wechat.message.model.receive;

import com.miles.wechat.message.enums.EventMessageType;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 取消关注的消息
 *
 * @author Michael
 */
@XmlRootElement(name = "xml")
public class EventUnsubscribeMessage extends EventMessage {
    @Override
    public String getEvent() {
        return EventMessageType.UNSUBSCRIBE.getValue();
    }
}
