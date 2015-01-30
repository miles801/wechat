package com.miles.wechat.event;

import com.miles.wechat.message.model.receive.EventNotSubscribeScanMessage;

/**
 * 当粉丝还没有关注公众平台时对二维码进行扫描触发的事件
 * <p>可以从Ticket中获取二维码图片</p>
 * <p>可以从EventKey中获取事件的Key值，qrscene_为前缀，后面为二维码的参数值</p>
 *
 * @author Michael
 */
public interface UnsubscribeScanEvent extends Event<EventNotSubscribeScanMessage> {
}
