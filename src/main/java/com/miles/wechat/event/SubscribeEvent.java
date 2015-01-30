package com.miles.wechat.event;

import com.miles.wechat.message.model.receive.EventSubscribeMessage;

/**
 * 当粉丝关注时的事件
 *
 * @author miles
 */
public interface SubscribeEvent extends Event<EventSubscribeMessage> {
}
