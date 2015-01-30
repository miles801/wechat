package com.miles.wechat.event;

import com.miles.wechat.message.model.receive.EventScanMessage;

/**
 * 粉丝已经关注后扫描二维码扫描的事件
 * <p>可以从Ticket中获取二维码的ticket，可用来换取二维码图片</p>
 * <p>可以从EventKey中获取事件的Key值，事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id</p>
 *
 * @author Michael
 */
public interface ScanEvent extends Event<EventScanMessage> {
}
