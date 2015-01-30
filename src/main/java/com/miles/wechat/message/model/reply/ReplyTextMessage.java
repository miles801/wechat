package com.miles.wechat.message.model.reply;

import com.miles.wechat.message.enums.ReplyMessageType;
import com.miles.wechat.message.model.NotNull;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 回复文本消息
 *
 * @author Michael
 */
@XmlRootElement(name = "xml")
public class ReplyTextMessage extends ReplyMessage {
    private String content;

    @XmlElement(name = "Content")
    @NotNull
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String getMessageType() {
        return ReplyMessageType.TEXT.getValue();
    }
}
