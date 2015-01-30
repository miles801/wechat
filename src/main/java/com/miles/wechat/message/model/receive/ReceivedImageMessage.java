package com.miles.wechat.message.model.receive;

import com.miles.wechat.message.enums.ReceivedMessageType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 接收到的图片消息
 *
 * @author Michael
 */
@XmlRootElement(name = "xml")
public class ReceivedImageMessage extends ReceivedMessage {
    /**
     * 图片链接
     */
    private String picUrl;

    /**
     * 图片消息媒体id，可以调用多媒体文件下载接口拉取数据
     */
    private String mediaId;

    @XmlElement(name = "PicUrl")
    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @XmlElement(name = "MediaId")
    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public String getMessageType() {
        return ReceivedMessageType.IMAGE.getValue();
    }
}
