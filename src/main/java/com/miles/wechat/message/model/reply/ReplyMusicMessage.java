package com.miles.wechat.message.model.reply;

import com.miles.wechat.message.enums.ReplyMessageType;
import com.miles.wechat.message.model.NotNull;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 回复视频消息
 *
 * @author Michael
 */
@XmlRootElement(name = "xml")
public class ReplyMusicMessage extends ReplyMessage {
    private Music music;

    class Music {
        private String title;
        private String description;
        /**
         * 音乐链接
         */
        private String musicUrl;
        /**
         * 高质量音乐链接，WIFI环境优先使用该链接播放音乐
         */
        private String HQMusicUrl;
        /**
         * 缩略图的媒体id，通过上传多媒体文件，得到的id
         */
        private String thumbMediaId;

        public Music() {
        }

        public Music(String thumbMediaId, String title, String description, String musicUrl, String HQMusicUrl) {
            this.thumbMediaId = thumbMediaId;
            this.title = title;
            this.description = description;
            this.musicUrl = musicUrl;
            this.HQMusicUrl = HQMusicUrl;
        }

        @XmlElement(name = "MusicUrl")
        public String getMusicUrl() {
            return musicUrl;
        }

        public void setMusicUrl(String musicUrl) {
            this.musicUrl = musicUrl;
        }

        @XmlElement(name = "HQMusicUrl")
        public String getHQMusicUrl() {
            return HQMusicUrl;
        }

        public void setHQMusicUrl(String HQMusicUrl) {
            this.HQMusicUrl = HQMusicUrl;
        }

        @XmlElement(name = "ThumbMediaId")
        @NotNull
        public String getThumbMediaId() {
            return thumbMediaId;
        }

        public void setThumbMediaId(String thumbMediaId) {
            this.thumbMediaId = thumbMediaId;
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

    @XmlElement(name = "Music")
    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    @Override
    public String getMessageType() {
        return ReplyMessageType.MUSIC.getValue();
    }

    /**
     * 添加/设置音乐对象的信息
     * <p>如果音乐对象已经存在，则直接设置信息，否则创建一个新的对象，然后再设置</p>
     *
     * @param thumbMediaId 必须，缩略图的媒体id，通过上传多媒体文件，得到的id
     * @param title        音乐标题
     * @param description  音乐描述
     * @param musicUrl     音乐链接
     * @param HQMusicUrl   高质量音乐链接，WIFI环境优先使用该链接播放音乐
     */
    public void addMusic(String thumbMediaId, String title, String description, String musicUrl, String HQMusicUrl) {
        if (music == null) {
            music = new Music();
        }
        music.setThumbMediaId(thumbMediaId);
        music.setTitle(title);
        music.setDescription(description);
        music.setMusicUrl(musicUrl);
        music.setHQMusicUrl(HQMusicUrl);
    }
}
