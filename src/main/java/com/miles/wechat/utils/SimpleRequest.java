package com.miles.wechat.utils;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 封装HttpClient相关的接口，提供简单的请求方式
 *
 * @author miles
 * @datetime 2014/5/15 1:49
 */
public class SimpleRequest {
    public static final int RESPONSE_SUCCESS = 200;
    private static Logger logger = Logger.getLogger(SimpleRequest.class);

    static {
        Properties properties = new Properties();
        try {
            properties.load(SimpleRequest.class.getClassLoader().getResourceAsStream("http.properties"));
            String host = properties.getProperty("http.proxy.host");
            String port = properties.getProperty("http.proxy.port");
            if (!StringUtils.isEmpty(host) && !StringUtils.isEmpty(port))
                proxy = new HttpHost(host, Integer.parseInt(port));
        } catch (IOException e) {
        }
    }
    public static HttpHost proxy;

    public static String doGet(String url) {
        String responseContent = null;
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(url);
            if (proxy != null) {
                httpClient.getParams().setParameter("http.route.default-proxy", proxy);
            }
            logger.info("GET : " + url);
            HttpResponse response = httpClient.execute(httpget);
            int status = response.getStatusLine().getStatusCode();
            if (status == RESPONSE_SUCCESS) {
                InputStream input = response.getEntity().getContent();
                responseContent = IOUtils.toString(input, "utf-8");
                logger.info("GET请求响应结果:" + responseContent);
                input.close();
            } else {
                logger.info("请求[" + url + "]失败:" + status);
            }
            httpClient.getConnectionManager().shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseContent;
    }

    public static String doPost(String url, HttpEntity entity) {
        String responseContent = null;
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            if (proxy != null) {
                httpClient.getParams().setParameter("http.route.default-proxy", proxy);
            }
            if (entity != null) {
                httpPost.setEntity(entity);
            }
            logger.info("POST : " + url);
            HttpResponse response = httpClient.execute(httpPost);
            int status = response.getStatusLine().getStatusCode();
            if (status == RESPONSE_SUCCESS) {
                if (response.getEntity() != null) {
                    InputStream input = response.getEntity().getContent();
                    responseContent = IOUtils.toString(input, "utf-8");
                    logger.info("POST请求响应结果:" + responseContent);
                    input.close();
                } else {
                    logger.info("请求[" + url + "]:没有获得响应内容!");
                }
            } else {
                logger.info("请求[" + url + "]失败:" + status);
            }
            httpClient.getConnectionManager().shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseContent;
    }

    public static String doXmlPost(String url, String xml) {
        if (xml == null) {
            throw new IllegalArgumentException("发送XML请求时，没有获得XML的内容!");
        }
        String responseContent = null;
        try {
            HttpClient httpClient = new DefaultHttpClient();
            if (proxy != null)
                httpClient.getParams().setParameter("http.route.default-proxy", proxy);
            HttpPost httpPost = new HttpPost(url);
            StringEntity entity = new StringEntity(xml, "xml/text", "utf-8");
            httpPost.setEntity(entity);
            logger.info("POST : " + url);
            HttpResponse response = httpClient.execute(httpPost);
            int status = response.getStatusLine().getStatusCode();
            if (status == RESPONSE_SUCCESS) {
                if (response.getEntity() != null) {
                    InputStream input = response.getEntity().getContent();
                    responseContent = IOUtils.toString(input, "utf-8");
                    logger.info("POST请求响应结果:" + responseContent);
                    input.close();
                } else {
                    logger.info("请求[" + url + "]:没有获得响应内容!");
                }
            } else {
                logger.info("请求[" + url + "]失败:" + status);
            }
            httpClient.getConnectionManager().shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseContent;
    }
}
