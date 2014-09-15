package com.miles.wechat.impl;

import com.miles.wechat.AbstractBasicTest;
import com.miles.wechat.api.MultiMediaService;
import com.miles.wechat.api.MultiMediaType;
import com.miles.wechat.core.ServiceLoader;
import com.miles.wechat.core.WeChatEngine;
import com.miles.wechat.entity.UploadInfo;
import junit.framework.Assert;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;

public class MultiMediaServiceImplTest extends AbstractBasicTest{
    private MultiMediaService multiMediaService;

    @Before
    public void setUp() throws Exception {
        ServiceLoader serviceLoader = ServiceLoader.newInstance();
        serviceLoader.setMultiMediaService(new MultiMediaServiceImpl());
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
}