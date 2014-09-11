package com.miles.wechat.entity.message;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author miles
 * @datetime 2014/5/7 0:41
 */
@XmlRootElement(name = "xml")
public class SendMessage extends AbstractMessage {
    /**
     * 文本消息
     */
    private String content;
    /**
     * 图片消息
     */
    private Image image;
    /**
     * 语音消息
     */
    private Voice voice;
    /**
     * 视频消息
     */
    private Video video;
    /**
     * 音乐消息
     */
    private Music music;
    /**
     * 图文消息
     */
    private Article article;
    private Integer articleCount;

    @XmlElement(name = "Content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @XmlElement(name = "Image")
    public Image getImage() {
        return image;
    }

    public void setImages(Image image) {
        this.image = image;
    }

    @XmlElement(name = "Voice")
    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    @XmlElement(name = "Video")
    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    @XmlElement(name = "Music")
    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    @XmlElement(name = "Articles")
    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }
}


