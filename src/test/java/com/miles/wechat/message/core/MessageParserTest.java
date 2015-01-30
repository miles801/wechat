package com.miles.wechat.message.core;

import com.miles.wechat.message.model.receive.ReceivedMessage;
import junit.framework.Assert;
import org.junit.Test;

public class MessageParserTest {

    @Test
    public void testParseXml() throws Exception {

    }

    @Test
    public void testParseToXml() throws Exception {
        String voiceXml = "<xml>\n" +
                "<ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                "<FromUserName><![CDATA[FromUser]]></FromUserName>\n" +
                "<CreateTime>123456789</CreateTime>\n" +
                "<MsgType><![CDATA[event]]></MsgType>\n" +
                "<Event><![CDATA[subscribe]]></Event>\n" +
                "</xml>";
        MessageParser parser = MessageParser.getInstance();
        ReceivedMessage message = parser.parseReceivedXml(voiceXml);
        System.out.println("eventType:" + message.getMessageType());
        System.out.println("isEvent:" + message.isEvent());
        System.out.println("-------------------------");
        String xml = parser.parseToXml(message);
        System.out.println(xml);


        Assert.assertEquals(voiceXml, xml);
    }
}