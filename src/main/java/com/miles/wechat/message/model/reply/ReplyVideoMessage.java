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
public class ReplyVideoMessage extends ReplyMessage {
    private Video video;

    class Video {
        private String mediaId;
        private String title;
        private String description;

        public Video() {
        }

        public Video(String mediaId, String title, String description) {
            this.mediaId = mediaId;
            this.title = title;
            this.description = description;
        }

        @XmlElement(name = "MediaId")
        @NotNull
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

    @XmlElement(name = "Video")
    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    @Override
    public String getMessageType() {
        return ReplyMessageType.VIDEO.getValue();
    }

    /**
     * 添加/设置视频消息
     * <p>如果video对象已经存在，则直接设置信息，如果不存在，则创建新的对象然后设置信息</p>
     *
     * @param mediaId     必须，视频上传后的id
     * @param title       视频的标题
     * @param description 视频的描述
     */
    public void addVideo(String mediaId, String title, String description) {
        if (video == null) {
            video = new Video();
        }
        video.setMediaId(mediaId);
        video.setTitle(title);
        video.setDescription(description);
    }
}
