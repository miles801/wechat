package com.miles.wechat.message.model.send;

import com.google.gson.annotations.SerializedName;
import com.miles.wechat.message.model.NotNull;

/**
 * @author Michael
 */
public class Article {
    public static final String SHOW_COVER_TRUE = "1";
    public static final String SHOW_COVER_FALSE = "0";
    /**
     * 图文消息缩略图的media_id，可以在基础支持-上传多媒体文件接口中获得
     */
    @NotNull
    @SerializedName("thumb_media_id")
    private String thumbMediaId;
    /**
     * 图文消息的作者
     */
    @NotNull
    private String author;
    /**
     * 图文消息的标题
     */
    @NotNull
    private String title;
    /**
     * 在图文消息页面点击“阅读原文”后的页面
     */
    @SerializedName("content_source_url")
    private String contentSourceUrl;
    /**
     * 图文消息页面的内容，支持HTML标签
     */
    @NotNull
    private String content;
    /**
     * 图文消息的描述
     */
    private String digest;

    /**
     * 是否显示封面：1为显示，0为不显示
     */
    @SerializedName("show_cover_pic")
    private String showCoverPic;

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentSourceUrl() {
        return contentSourceUrl;
    }

    public void setContentSourceUrl(String contentSourceUrl) {
        this.contentSourceUrl = contentSourceUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getShowCoverPic() {
        return showCoverPic;
    }

    public void setShowCoverPic(String showCoverPic) {
        this.showCoverPic = showCoverPic;
    }
}
