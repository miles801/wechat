package com.miles.wechat.event;

import com.miles.wechat.message.model.receive.EventLocationMessage;

/**
 * 上报地理位置消息事件
 * <p>用户同意上报地理位置后，每次进入公众号会话时，都会在进入时上报地理位置，或在进入会话后每5秒上报一次地理位置</p>
 *
 * @author miles
 */
public interface ReportLocationEvent extends Event<EventLocationMessage> {
}
