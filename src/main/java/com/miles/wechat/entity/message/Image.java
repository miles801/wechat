package com.miles.wechat.entity.message;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author miles
 * @datetime 2014/5/23 10:48
 */
public class Image {
    private String mediaId;

    @XmlElement(name = "MediaId")
    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}

