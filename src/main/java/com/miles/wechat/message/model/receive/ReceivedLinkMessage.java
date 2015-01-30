package com.miles.wechat.message.model.receive;

import com.miles.wechat.message.enums.ReceivedMessageType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 接收到链接消息
 *
 * @author Michael
 */
@XmlRootElement(name = "xml")
public class ReceivedLinkMessage extends ReceivedMessage {
    /**
     * 链接要显示的标题
     */
    private String title;
    /**
     * 链接描述
     */
    private String description;
    /**
     * 链接的地址
     */
    private String url;

    @XmlElement(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement(name = "Url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getMessageType() {
        return ReceivedMessageType.LINK.getValue();
    }
}
