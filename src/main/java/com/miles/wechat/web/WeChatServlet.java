package com.miles.wechat.web;

import com.miles.wechat.api.MessageType;
import com.miles.wechat.core.WeChatEngine;
import com.miles.wechat.entity.message.ReceiveMessage;
import com.miles.wechat.entity.message.SendMessage;
import com.miles.wechat.event.Event;
import com.miles.wechat.utils.StringUtils;
import com.miles.wechat.utils.XmlUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * 与微信进行交互的servlet
 *
 * @author miles
 * @datetime 2014/5/21 21:55
 */
public class WeChatServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(WeChatServlet.class);
    private WeChatEngine engine = WeChatEngine.newInstance();

    /**
     * 微信URL合法性验证
     * 可获取参数：
     * signature
     * timestamp
     * echostr
     * nonce
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //验证
        String signature = request.getParameter("signature");
        if (StringUtils.isEmpty(signature)) {
            throw new SecurityException("非法的微信请求!");
        }
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        logger.info("验证消息:signature=" + signature + " , nonce=" + nonce + " , echostr=" + echostr + " , timestamp=" + timestamp);
        boolean result = engine.getBasicService().signature(signature, timestamp, nonce);
        if (!result) {
            logger.error("微信请求认证失败!");
            return;
        }
        ServletOutputStream out = response.getOutputStream();
        out.print(echostr);
        out.close();

    }

    /**
     * 微信客户端POST过来的数据
     *
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputStream in = request.getInputStream();
        ReceiveMessage content = XmlUtils.fromXml(in, ReceiveMessage.class);
        if (content == null) {
            throw new RuntimeException("没有接收到任何内容!");
        }
        String type = content.getMessageType().trim();
        logger.info("微信[" + content.getToUserName() + "]接收到来自[" + content.getFromUserName() + "]的消息[" + type + "]!");
        SendMessage sendMessage = null;
        Event event = null;
        String eventType = "";
        if (MessageType.TEXT.getValue().equals(type)) {
            event = engine.getReceiveTextMsgEvent();
        } else if (MessageType.IMAGE.getValue().equals(type)) {
            event = engine.getReceiveImageMsgEvent();
        } else if (MessageType.VIDEO.getValue().equals(type)) {
            event = engine.getReceiveVideoMsgEvent();
        } else if (MessageType.LOCATION.getValue().equals(type)) {
            event = engine.getReceiveLocationMsgEvent();
        } else if (MessageType.LINK.getValue().equals(type)) {
            event = engine.getReceiveLinkMsgEvent();
        } else if (MessageType.EVENT.getValue().equals(type)) {
            eventType = content.getEvent();
            if ("subscribe".equals(eventType)) {
                event = engine.getSubscribeEvent();
            } else if ("unsubscribe".equals(eventType)) {
                event = engine.getUnsubscribeEvent();
            } else if ("location".equals(eventType)) {
                event = engine.getReportLocationEvent();
            } else if ("click".equals(eventType)) {
                event = engine.getMenuClickEvent();
            } else if ("view".equals(eventType)) {
                event = engine.getMenuViewEvent();
            } else {
                logger.error("未识别的Event[" + eventType + "]!");
            }
        } else {
            logger.error("未识别的消息类型[" + type + "]!");
        }
        if (event == null) {
            logger.error("不能处理的消息!\t消息类型[" + type + "]，事件类型[" + eventType + "]的事件处理器没有初始化!");
            return;
        }
        sendMessage = event.execute(content);
        if (sendMessage != null) {
            String xml = XmlUtils.toXml(sendMessage, SendMessage.class);
            response.setContentType("application/xml");
            response.setCharacterEncoding("utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(xml);
            writer.flush();
            writer.close();
        }
    }

    @Override
    public void destroy() {
        logger.info("销毁微信Servlet....");
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        logger.info("初始化微信Servlet....");
        super.init();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
