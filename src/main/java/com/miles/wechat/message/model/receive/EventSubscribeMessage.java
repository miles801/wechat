package com.miles.wechat.message.model.receive;

import com.miles.wechat.message.enums.EventMessageType;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Michael
 */
@XmlRootElement(name = "xml")
public class EventSubscribeMessage extends EventMessage {
    @Override
    public String getEvent() {
        return EventMessageType.SUBSCRIBE.getValue();
    }

}
