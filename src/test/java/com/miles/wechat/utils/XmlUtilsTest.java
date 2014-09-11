package com.miles.wechat.utils;

import com.miles.wechat.entity.message.ReceiveMessage;
import junit.framework.Assert;
import org.junit.Test;

public class XmlUtilsTest {

    @Test
    public void testFromXml() throws Exception {
        String xml = "<xml>\n" +
                "<ToUserName><![CDATA[miles]]></ToUserName>\n" +
                "<FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                "<CreateTime>1351776360</CreateTime>\n" +
                "<MsgType><![CDATA[link]]></MsgType>\n" +
                "<Title><![CDATA[公众平台官网链接]]></Title>\n" +
                "<Description><![CDATA[公众平台官网链接]]></Description>\n" +
                "<Url><![CDATA[url]]></Url>\n" +
                "<MsgId>1234567890123456</MsgId>\n" +
                "</xml> ";
        ReceiveMessage content = XmlUtils.fromXml(xml, ReceiveMessage.class);
        Assert.assertNotNull(content);
        Assert.assertEquals("miles", content.getToUserName());
        Assert.assertEquals("link", content.getMessageType());
        String data = XmlUtils.toXml(content, ReceiveMessage.class);
        System.out.println(data);
    }
}