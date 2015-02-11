package com.miles.wechat.message.core;

import com.miles.wechat.core.WeChatContext;
import com.miles.wechat.core.WeChatEngine;
import com.miles.wechat.exceptions.WeChatMessageException;
import com.miles.wechat.message.enums.ReceivedMessageType;
import com.miles.wechat.message.model.receive.*;
import com.miles.wechat.message.model.reply.ReplyMessage;
import com.miles.wechat.utils.StringUtils;
import org.apache.log4j.Logger;

/**
 * 消息处理机
 * <p>用于处理接收到的消息或者在发送消息前对消息进行处理</p>
 *
 * @author Michael
 */
public class MessageHandler {

    private static MessageHandler messageHandler = new MessageHandler();
    private Logger logger = Logger.getLogger(MessageHandler.class);

    private MessageHandler() {
    }

    public static MessageHandler getInstance() {
        return messageHandler;
    }

    /**
     * 处理接收到的消息
     *
     * @param message 消息主体
     * @return 要响应给服务器的数据（字符串）
     */
    public String handle(String message) {
        // 解析
        MessageParser parser = MessageParser.getInstance();
        ReceivedMessage receivedMessage = parser.parseReceivedXml(message);

        // 初始化上下文
        WeChatContext.set(receivedMessage.getToUserName());
        // 处理，暂不处理
        // 过滤，暂不处理
        // 转换，暂不处理
        // 触发消息接收事件
        ReplyMessage replyMessage = fireEvent(receivedMessage);

        // 清空上下文
        WeChatContext.remove();

        // 回复信息检查
        try {
            if (isValidReplyMessage(replyMessage)) {
                return parser.parseToXml(replyMessage);
            }
        } catch (WeChatMessageException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 检查回复的消息是否为正确的消息
     */
    private boolean isValidReplyMessage(ReplyMessage replyMessage) throws WeChatMessageException {
        if (replyMessage == null) {
            return false;
        }

        if (StringUtils.isEmpty(replyMessage.getFromUserName())) {
            throw new WeChatMessageException("无效的消息!没有指定消息的发送人!");
        }
        if (StringUtils.isEmpty(replyMessage.getToUserName())) {
            throw new WeChatMessageException("无效的消息!没有指定消息的接收人!");
        }
        if (StringUtils.isEmpty(replyMessage.getMessageType())) {
            throw new WeChatMessageException("无效的消息!没有指定消息的类型!");
        }
        return true;
    }

    /**
     * 根据接收到的消息类型触发对应的事件
     * <p>
     * 如果对应的事件没有注册，则在执行过程中会抛出空指针异常!
     * </p>
     *
     * @param receivedMessage 接收到的消息对象
     * @return 要回复的消息对象
     */
    private ReplyMessage fireEvent(ReceivedMessage receivedMessage) {

        WeChatEngine engine = WeChatEngine.newInstance();
        String msgType = receivedMessage.getMessageType();
        ReplyMessage replyMessage = null;
        logger.info("公众号[" + receivedMessage.getToUserName() + "]接收到来自[" + receivedMessage.getFromUserName() + "]的[" + msgType + "(" + receivedMessage.getEventType() + ")]消息!");
        if (ReceivedMessageType.TEXT.getValue().equals(msgType)) {
            replyMessage = engine.getReceiveTextMsgEvent().execute((ReceivedTextMessage) receivedMessage);
        } else if (ReceivedMessageType.IMAGE.getValue().equals(msgType)) {
            replyMessage = engine.getReceiveImageMsgEvent().execute((ReceivedImageMessage) receivedMessage);
        } else if (ReceivedMessageType.VIDEO.getValue().equals(msgType)) {
            replyMessage = engine.getReceiveVideoMsgEvent().execute((ReceivedVideoMessage) receivedMessage);
        } else if (ReceivedMessageType.LOCATION.getValue().equals(msgType)) {
            replyMessage = engine.getReceiveLocationMsgEvent().execute((ReceivedLocationMessage) receivedMessage);
        } else if (ReceivedMessageType.LINK.getValue().equals(msgType)) {
            replyMessage = engine.getReceiveLinkMsgEvent().execute((ReceivedLinkMessage) receivedMessage);
        } else if (ReceivedMessageType.EVENT.getValue().equals(msgType)) {
            String eventType = receivedMessage.getEventType();
            if ("subscribe".equalsIgnoreCase(eventType)) {
                replyMessage = engine.getSubscribeEvent().execute((EventSubscribeMessage) receivedMessage);
            } else if ("unsubscribe".equalsIgnoreCase(eventType)) {
                replyMessage = engine.getUnsubscribeEvent().execute((EventUnsubscribeMessage) receivedMessage);
            } else if ("location".equalsIgnoreCase(eventType)) {
                replyMessage = engine.getReportLocationEvent().execute((EventLocationMessage) receivedMessage);
            } else if ("click".equalsIgnoreCase(eventType)) {
                replyMessage = engine.getMenuClickEvent().execute((EventMenuClickMessage) receivedMessage);
            } else if ("view".equalsIgnoreCase(eventType)) {
                replyMessage = engine.getMenuViewEvent().execute((EventMenuLinkMessage) receivedMessage);
            } else {
                logger.error("未识别的Event类型[" + eventType + "]!");
            }
        } else {
            logger.error("未识别的消息类型[" + msgType + "]!");
        }
        return replyMessage;
    }


}
