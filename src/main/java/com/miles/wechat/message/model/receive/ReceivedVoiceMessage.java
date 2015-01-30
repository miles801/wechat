package com.miles.wechat.message.model.receive;

import com.miles.wechat.message.enums.ReceivedMessageType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 接收到的语音消息
 *
 * @author Michael
 */
@XmlRootElement(name = "xml")
public class ReceivedVoiceMessage extends ReceivedMessage {
    /**
     * 语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    private String mediaId;

    /**
     * 语音格式，如amr，speex等
     */
    private String format;

    /**
     * 只适用于开通语音识别功能的公众号
     * 语音识别结果，UTF8编码;
     * 注意：对新关注立即生效，已关注用户24小时内生效
     */
    private String recognition;

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

    @XmlElement(name = "Recognition")
    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }

    @Override
    public String getMessageType() {
        return ReceivedMessageType.VOICE.getValue();
    }
}
