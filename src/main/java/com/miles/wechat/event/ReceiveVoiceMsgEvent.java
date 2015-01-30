package com.miles.wechat.event;

import com.miles.wechat.message.model.receive.ReceivedVoiceMessage;

/**
 * 接收语音消息事件
 *
 * @author miles
 */
public interface ReceiveVoiceMsgEvent extends Event<ReceivedVoiceMessage> {
}
