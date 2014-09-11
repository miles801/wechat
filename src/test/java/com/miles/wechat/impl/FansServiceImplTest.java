package com.miles.wechat.impl;

import com.miles.wechat.api.FansService;
import com.miles.wechat.core.ServiceLoader;
import com.miles.wechat.core.WeChatEngine;
import com.miles.wechat.entity.Fans;
import com.miles.wechat.entity.FansData;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class FansServiceImplTest {
    public static final String openid = "oQ3C4uMUBlTeVHCCyw-QWfO0P-Cs";
    private FansService fansService;

    @Before
    public void setUp() throws Exception {
        ServiceLoader serviceLoader = ServiceLoader.newInstance();
        serviceLoader.setWeChatContext(SimpleWeChatContext.getInstance());
        WeChatEngine engine = WeChatEngine.newInstance();
        fansService = new FansServiceImpl();
    }

    @Test
    public void testFansList() throws Exception {
        Assert.assertNotNull(fansService);
        FansData data = fansService.fansList(null);
        Assert.assertNotNull(data);
        Assert.assertTrue(data.getTotal() > 0);
    }

    @Test
    public void testGetFansInfo() throws Exception {
        Fans fans = fansService.getFansInfo(openid);
        Assert.assertNotNull(fans);
        Assert.assertSame(openid, fans.getOpenId());
    }

}