package com.miles.wechat.entity.message;

import com.miles.wechat.api.MessageType;

import java.util.Date;

/**
 * 空消息
 * 对象默认为文本、内容为空、创建时间为当前时间
 * Created by Michael on 2014/9/18.
 */
public class EmptyMessage extends SendMessage {

    public EmptyMessage() {
        setMessageType(MessageType.TEXT.getValue());
        setContent("");
        setCreateTime(new Date().getTime());
    }

}
