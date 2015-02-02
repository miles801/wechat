package com.miles.wechat.impl;

import com.miles.wechat.WeChatBaseTest;
import com.miles.wechat.api.MultiMediaService;
import com.miles.wechat.api.MultiMediaType;
import com.miles.wechat.core.WeChatEngine;
import com.miles.wechat.entity.UploadInfo;
import com.miles.wechat.message.model.send.Article;
import com.miles.wechat.message.model.send.News;
import com.miles.wechat.utils.GsonHelper;
import junit.framework.Assert;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;

public class MultiMediaServiceImplTest extends WeChatBaseTest {
    private MultiMediaService multiMediaService;

    private Logger logger = Logger.getLogger(MultiMediaServiceImplTest.class);

    @Before
    public void setUp() throws Exception {
        WeChatEngine engine = WeChatEngine.newInstance();
        multiMediaService = engine.getMultiMediaService();
    }

    @Test
    public void testUpload() throws Exception {
        Assert.assertNotNull(multiMediaService);
        InputStream input = MultiMediaServiceImplTest.class.getClassLoader().getResourceAsStream("upload.jpg");
        Assert.assertNotNull(input);
        File tempFile = new File(System.getProperty("java.io.tmpdir") + "美女.jpg");
        FileUtils.copyInputStreamToFile(input, tempFile);
        UploadInfo info = multiMediaService.upload(tempFile, MultiMediaType.IMAGE);
        Assert.assertNotNull(info);
        Assert.assertNotNull(info.getMediaId());
        Assert.assertNotNull(info.getCreatedTime());
        System.out.println(info.getMediaId());
    }

    @Test
    public void testDownload() throws Exception {
        File file = multiMediaService.download("rKZz9552Zu6ZuKkcTgMB4Rf6S8vhqjzcRJmAYgu5RFXo3IRGSWr5zfZ_w33aBIzd", "d:/");
        Assert.assertNotNull(file);
        Assert.assertTrue(file.exists());
    }

    @Test
    public void testUploadNews() throws Exception {
        logger.info("测试上传多图文消息...");
        // 上传图片获得mediaId
        /*InputStream input = MultiMediaServiceImplTest.class.getClassLoader().getResourceAsStream("news.jpg");
        Assert.assertNotNull(input);
        File tempFile = new File(System.getProperty("java.io.tmpdir") + "news.jpg");
        FileUtils.copyInputStreamToFile(input, tempFile);
        UploadInfo info = multiMediaService.upload(tempFile, MultiMediaType.IMAGE);
        String mediaId = info.getMediaId();*/
        String mediaId = "ypc_tIL4O07TAKaf9un1Y8Hit73gPbmqWhXDkjaGF1ufPKpiJUmAopZF57NLhDMA";
        Assert.assertNotNull(mediaId);
        logger.info("图片上传成功后返回的mediaId为：" + mediaId);
        // 设置图文消息内容
        News news = new News();
        Article article = new Article();
        article.setAuthor("Michael");
        article.setContent("万达微信消息推送测试...");
        article.setDigest("http://www.wanda.cn/mobile/feedback/");
        article.setThumbMediaId(mediaId);
        article.setShowCoverPic(Article.SHOW_COVER_TRUE);
        article.setTitle("消息推送测试");
        news.addArticle(article);

        // 上传图文消息
        String json = GsonHelper.toJson(news);
        UploadInfo info2 = multiMediaService.uploadNews(json);
        // 获得返回的图文消息的mediaId
        String newsMediaId = info2.getMediaId();
        Assert.assertNotNull(newsMediaId);
        logger.info("图文上传成功，mediaId为：" + newsMediaId);
    }
}