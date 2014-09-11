package com.miles.wechat.entity.message;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author miles
 * @datetime 2014/5/7 0:08
 */
@XmlRootElement(name = "xml")
public class ReceiveMessage extends AbstractMessage {
    private String event;
    private String eventKey;
    private String content;
    private String picUrl;
    private String mediaId;
    /**
     * 语音格式
     */
    private String format;
    private String thumbMediaId;

    /**
     * 纬度
     */
    private String x;
    /**
     * 经度
     */
    private String y;
    /**
     * 缩放大小
     */
    private Integer scale;
    private String label;


    private String title;
    private String description;
    private String url;

    @XmlElement(name = "Event")
    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @XmlElement(name = "EventKey")
    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    @XmlElement(name = "Content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

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

    @XmlElement(name = "Format")
    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @XmlElement(name = "ThumbMediaId")
    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    @XmlElement(name = "Location_X")
    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    @XmlElement(name = "Location_Y")
    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    @XmlElement(name = "Scale")
    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    @XmlElement(name = "Label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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

    @XmlElement(name = "Url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
