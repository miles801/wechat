package com.miles.wechat.message.model.reply;

import com.miles.wechat.message.enums.ReplyMessageType;
import com.miles.wechat.message.model.NotNull;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 回复图片消息
 *
 * @author Michael
 */
@XmlRootElement(name = "xml")
public class ReplyImageMessage extends ReplyMessage {
    private Image image;

    @XmlElement(name = "Image")
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    class Image {
        private String mediaId;

        public Image() {
        }

        public Image(String mediaId) {
            this.mediaId = mediaId;
        }

        @XmlElement(name = "MediaId")
        @NotNull
        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }

    @Override
    public String getMessageType() {
        return ReplyMessageType.IMAGE.getValue();
    }

    /**
     * 设置/添加图片消息信息
     * <p>如果image对象已经存在，则直接设置信息，否则创建新的对象，然后设置信息</p>
     *
     * @param mediaId 图片上传后的id
     */
    public void addImage(String mediaId) {
        if (image == null) {
            image = new Image();
        }
        image.setMediaId(mediaId);
    }
}
