package com.miles.wechat.message.model.receive;

import com.miles.wechat.message.enums.EventMessageType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 还未进行关注时的二维码扫描事件
 *
 * @author Michael
 */
@XmlRootElement(name = "xml")
public class EventNotSubscribeScanMessage extends EventMessage {
    public EventNotSubscribeScanMessage() {
    }

    /**
     * 事件KEY值，qrscene_为前缀，后面为二维码的参数值
     */
    private String eventKey;
    /**
     * 二维码的ticket，可用来换取二维码图片
     */
    private String ticket;

    @XmlElement(name = "EventKey")
    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    @XmlElement(name = "Ticket")
    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    @Override
    public String getEvent() {
        return EventMessageType.SUBSCRIBE.getValue();
    }
}
