package com.miles.wechat.event;

import com.miles.wechat.entity.message.ReceiveMessage;
import com.miles.wechat.entity.message.SendMessage;

/**
 * 微信核心接口，当微信post数据到本地服务器时，将会触发一个事件
 * 通过实现该接口来实现处理接收到的数据并进行回复的功能
 *
 * @author miles
 * @datetime 2014/5/22 7:14
 */
public interface Event {
    SendMessage execute(ReceiveMessage receiveMessage);
}
