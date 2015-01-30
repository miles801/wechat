package com.miles.wechat.message.model.reply;

import com.miles.wechat.message.enums.ReplyMessageType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 回复语音消息
 *
 * @author Michael
 */
@XmlRootElement(name = "xml")
public class ReplyVoiceMessage extends ReplyMessage {
    private Voice voice;

    @XmlElement(name = "Voice")
    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    class Voice {
        private String mediaId;

        @XmlElement(name = "MediaId")
        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }

    @Override
    public String getMessageType() {
        return ReplyMessageType.VOICE.getValue();
    }


    /**
     * 添加/设置音频对象
     *
     * @param mediaId 上传附件后获得的音频的id
     */
    public void addVoice(String mediaId) {
        if (voice == null) {
            voice = new Voice();
        }
        voice.setMediaId(mediaId);
    }
}
