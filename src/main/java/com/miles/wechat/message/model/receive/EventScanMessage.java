package com.miles.wechat.message.model.receive;

import com.miles.wechat.message.enums.EventMessageType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 二维码扫描事件（已关注后的扫描）
 *
 * @author Michael
 */
@XmlRootElement(name = "xml")
public class EventScanMessage extends EventMessage {
    public EventScanMessage() {
    }

    /**
     * 事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
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
        return EventMessageType.SCAN.getValue();
    }

}
