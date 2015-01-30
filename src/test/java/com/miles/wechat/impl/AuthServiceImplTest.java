package com.miles.wechat.impl;

import com.miles.wechat.core.PublicServiceLoader;
import com.miles.wechat.core.WeChatEngine;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class AuthServiceImplTest {

    @Before
    public void setUp() throws Exception {
        PublicServiceLoader publicServiceLoader = PublicServiceLoader.getInstance();
        publicServiceLoader.setCacheAccount(new SimpleCacheAccount());
        WeChatEngine.newInstance();
    }

    @Test
    public void testSignature() throws Exception {
        WeChatEngine engine = WeChatEngine.newInstance();
        boolean result = engine.getAuthService().signature("gh_36f3110ed079", "09b2b1961f9d89a9bced725dfe321ca12d5c2951",
                "1422339658", "1591857761");
        Assert.assertTrue(result);

    }
}