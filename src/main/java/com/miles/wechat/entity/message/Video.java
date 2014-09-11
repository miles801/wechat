package com.miles.wechat.entity.message;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author miles
 * @datetime 2014/5/23 10:47
 */
public class Video {
    private String mediaId;
    private String title;
    private String description;

    @XmlElement(name = "MediaId")
    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

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
}
