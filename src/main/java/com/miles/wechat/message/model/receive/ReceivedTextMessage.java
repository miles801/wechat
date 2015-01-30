package com.miles.wechat.message.model.receive;

import com.miles.wechat.message.enums.ReceivedMessageType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 接收到的文本消息
 *
 * @author Michael
 */
@XmlRootElement(name = "xml")
public class ReceivedTextMessage extends ReceivedMessage {
    /**
     * 文本内容
     */
    private String content;

    @XmlElement(name = "Content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String getMessageType() {
        return ReceivedMessageType.TEXT.getValue();
    }
}
