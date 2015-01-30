package com.miles.wechat.message.model.meta;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Michael
 */
public class ArticleItem {
    private String title;
    private String description;
    private String picUrl;
    private String url;

    public ArticleItem() {
    }

    public ArticleItem(String title, String description, String url, String picUrl) {
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.url = url;
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

    @XmlElement(name = "PicUrl")
    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @XmlElement(name = "Url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
