package com.miles.wechat.message.model.receive;

import com.miles.wechat.message.enums.ReceivedMessageType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 接收到地理位置消息
 *
 * @author Michael
 */
@XmlRootElement(name = "xml")
public class ReceivedLocationMessage extends ReceivedMessage {

    /**
     * 地理位置：纬度
     */
    private String locationX;
    /**
     * 地理位置：经度
     */
    private String locationY;
    /**
     * 地图缩放大小
     */
    private Integer scale;
    /**
     * 地理位置的描述信息
     */
    private String label;

    @XmlElement(name = "Location_X")
    public String getLocationX() {
        return locationX;
    }

    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    @XmlElement(name = "Location_Y")
    public String getLocationY() {
        return locationY;
    }

    public void setLocationY(String locationY) {
        this.locationY = locationY;
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

    @Override
    public String getMessageType() {
        return ReceivedMessageType.LOCATION.getValue();
    }
}
