package com.miles.wechat.message.model.receive;

import com.miles.wechat.message.enums.ReceivedMessageType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 上报地理位置的事件消息
 *
 * @author Michael
 */
@XmlRootElement(name = "xml")
public class EventLocationMessage extends EventMessage {
    /**
     * 地理位置：纬度
     */
    private Float latitude;
    /**
     * 地理位置：经度
     */
    private Float longitude;
    /**
     * 显示精度
     */
    private Float precision;

    @XmlElement(name = "Latitude")
    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    @XmlElement(name = "Longitude")
    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    @XmlElement(name = "Precision")
    public Float getPrecision() {
        return precision;
    }

    public void setPrecision(Float precision) {
        this.precision = precision;
    }

    @Override
    public String getEvent() {
        return ReceivedMessageType.LOCATION.getValue();
    }
}
