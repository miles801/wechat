package com.miles.wechat.message.core;

import com.miles.wechat.message.enums.EventMessageType;
import com.miles.wechat.message.enums.ReceivedMessageType;
import com.miles.wechat.message.model.receive.*;
import com.miles.wechat.utils.StringUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 消息解析器：将xml转成实体类、将实体类转换成xml
 *
 * @author Michael
 */
public class MessageParser {
    /**
     * 存放消息类型对应的消息类
     */
    private static Map<String, Class<? extends ReceivedMessage>> receivedMsgMap = new HashMap<String, Class<? extends ReceivedMessage>>();

    /**
     * 映射事件类型
     */
    private static Map<String, Class<? extends EventMessage>> eventMsgMap = new HashMap<String, Class<? extends EventMessage>>();
    private static MessageParser parser = new MessageParser();

    static {
        // 注册消息解析类型
        receivedMsgMap.put(ReceivedMessageType.TEXT.getValue(), ReceivedTextMessage.class);
        receivedMsgMap.put(ReceivedMessageType.IMAGE.getValue(), ReceivedImageMessage.class);
        receivedMsgMap.put(ReceivedMessageType.VOICE.getValue(), ReceivedVoiceMessage.class);
        receivedMsgMap.put(ReceivedMessageType.VIDEO.getValue(), ReceivedVideoMessage.class);
        receivedMsgMap.put(ReceivedMessageType.LINK.getValue(), ReceivedLinkMessage.class);
        receivedMsgMap.put(ReceivedMessageType.LOCATION.getValue(), ReceivedLocationMessage.class);
        receivedMsgMap.put(ReceivedMessageType.EVENT.getValue(), EventMessage.class);

        // 注册事件解析类型
        eventMsgMap.put(EventMessageType.SUBSCRIBE.getValue(), EventSubscribeMessage.class);
        eventMsgMap.put(EventMessageType.UNSUBSCRIBE.getValue(), EventUnsubscribeMessage.class);
        eventMsgMap.put(EventMessageType.SCAN.getValue(), EventScanMessage.class);
        eventMsgMap.put(EventMessageType.MENU_CLICK.getValue(), EventMenuClickMessage.class);
        eventMsgMap.put(EventMessageType.MENU_LINK.getValue(), EventMenuLinkMessage.class);
        eventMsgMap.put(EventMessageType.LOCATION.getValue(), EventLocationMessage.class);
    }

    private MessageParser() {
    }

    public static MessageParser getInstance() {
        return parser;
    }

    /**
     * 将从微信接收到的XML转换成对应的ReceivedMessage对象
     * <p>可以通过ReceivedMessage#getRealClass()获得真实的对象</p>
     *
     * @param xml xml内容
     */
    public ReceivedMessage parseReceivedXml(String xml) {
        if (StringUtils.isEmpty(xml)) {
            return null;
        }
        // 获取MsgType的值
        String msgType = getContentFromXml(xml, "MsgType");
        if (StringUtils.isEmpty(msgType)) {
            throw new RuntimeException("无效的微信请求!没有获得MsgType!");
        }

        // 获得消息类型
        Class<? extends ReceivedMessage> clazz = null;
        String eventType = null;
        if (msgType.equalsIgnoreCase("event")) {
            // 获得具体的event
            eventType = getContentFromXml(xml, "Event");
            clazz = eventMsgMap.get(eventType);
        } else {
            clazz = receivedMsgMap.get(msgType);
        }
        if (clazz == null) {
            throw new SecurityException("无效的微信请求，没有获得MsgType[" + msgType + "]对应的解析器!");
        }

        // 将xml转换成对应的消息类型
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ReceivedMessage receivedMessage = (ReceivedMessage) unmarshaller.unmarshal(new StringReader(xml));
            // 注册实际的消息类型
            receivedMessage.setRealClass(clazz);
            if (EventMessage.class.isAssignableFrom(clazz)) {
                receivedMessage.setEvent(true);
                receivedMessage.setEventType(eventType);
            }
            return receivedMessage;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 将指定的对象转换成xml字符串
     * 如果对象为空，则直接返回null
     *
     * @param o javabean
     * @return xml字符串
     */
    public String parseToXml(Object o) {
        if (o == null) {
            return null;
        }
        try {
            JAXBContext context = JAXBContext.newInstance(o.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter writer = new StringWriter();
            marshaller.marshal(o, writer);
            String xml = writer.toString();
            writer.close();
            return xml;
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从xml中选择指定节点名称的内容，如果节点不存在，则返回null
     * <p>节点必须使用正常的方式关闭，如果使用<NodeName />这种方式会抛出异常！</p>
     *
     * @param xmlContent xml内容
     * @param nodeName   节点名称
     * @return 节点内容
     */
    private String getContentFromXml(String xmlContent, String nodeName) {
        int length = nodeName.length() + 2;
        int start = xmlContent.indexOf("<" + nodeName + ">");
        if (start == -1) {
            return null;
        }
        int end = xmlContent.indexOf("</" + nodeName + ">", start);
        if (end < start) {
            throw new RuntimeException("不合法的XML，<" + nodeName + ">没有找到对应的关闭节点!");
        }
        String content = xmlContent.substring(start + length, end).replaceAll("(<!\\[CDATA\\[)|(\\]\\]>)", "");
        if (StringUtils.isEmpty(content)) {
            throw new RuntimeException("无效的微信请求!没有获得MsgType!");
        }
        return content;
    }
}
