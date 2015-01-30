package com.miles.wechat.web;

import com.miles.wechat.core.WeChatEngine;
import com.miles.wechat.message.core.MessageHandler;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 与微信进行交互的servlet，微信接入地址（在微信开发者配置页面配置访问的地址为该Servlet）
 * <p>
 * 提供接入和接收消息（回复消息）两个接口
 * </p>
 * <p>
 * 可以在该地址后面添加参数originalId（微信原始账号ID） 用于在当前系统中同时处理多个公众号信息的；
 * 如果没有指定这个参数，则会判断账号池中的账号个数，如果个数不等于1，则抛出异常!
 * </p>
 *
 * @author miles
 * @datetime 2014/5/21 21:55
 */
public class WeChatServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(WeChatServlet.class);
    private WeChatEngine engine = WeChatEngine.newInstance();

    /**
     * 微信接入
     * 可获取参数：
     * <p>
     * originalId 公众号原始ID（配置URL地址时指定，可选，推荐配置）<br/>
     * 注意：微信不允许在接入时指定参数，所以这个值必须是在地址栏中存在；<br/>
     * 可以通过一个第三方的访问地址追加originalId的方式forward到当前servlet
     * <p/>
     * <p>
     * signature  加密签名(由以下3个信息加密而来）
     * </p>
     * <p>
     * timestamp 时间戳
     * </p>
     * <p>
     * nonce 随机数
     * </p>
     * <p>
     * echostr 随机字符串
     * </p>
     * <p>
     * 当接入失败时，会触发AuthFailEvent（认证失败）事件
     * </p>
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //验证
        if (verifyRequest(request)) {
            ServletOutputStream out = response.getOutputStream();
            String echostr = request.getParameter("echostr");
            out.print(echostr);
            out.close();
        }
    }

    /**
     * 接收微信发送的数据（POST)，
     * 会先判断消息的合法性，然后再将接收到的消息转交给消息处理机进行处理，最后响应消息
     *
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 验证消息的合法性
        if (!verifyRequest(request)) {
            logger.error("请求认证失败!");
            // 验证失败
            return;
        }
        request.setCharacterEncoding("utf-8");
        // 获取微信发送过来的内容
        String content = IOUtils.toString(request.getInputStream(), "utf-8");

        // 将消息交给消息处理机
        MessageHandler messageHandler = MessageHandler.getInstance();

        // 响应消息
        String responseMsg = messageHandler.handle(content);
        if (responseMsg != null) {
            response.setContentType("application/xml");
            response.setCharacterEncoding("utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(responseMsg);
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

    /**
     * 验证请求是否合法
     * <p>如果合法，则返回正确的字符串，否则返回null</p>
     */
    private boolean verifyRequest(HttpServletRequest request) {
        // 获取参数
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String originalId = request.getParameter("originalId");
        String echostr = request.getParameter("echostr");
        logger.info("验证消息:originalId=" + originalId + ",signature=" + signature + " , nonce=" + nonce + " , echostr=" + echostr + " , timestamp=" + timestamp);

        // 认证
        return engine.getAuthService().signature(originalId, signature, timestamp, nonce);
    }
}
