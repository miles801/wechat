package com.miles.wechat.impl;

import com.miles.wechat.AbstractBasicTest;
import com.miles.wechat.core.PublicServiceLoader;
import com.miles.wechat.core.TokenPool;
import com.miles.wechat.core.WeChatEngine;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 测试获取AccessToken
 * Created by Michael on 2014/9/15.
 */
public class AccessTokenTest extends AbstractBasicTest {

    @Before
    public void setUp() throws Exception {
        PublicServiceLoader publicServiceLoader = PublicServiceLoader.getInstance();
        publicServiceLoader.setCacheAccount(new SimpleCacheAccount());
        WeChatEngine.newInstance();
    }

    @Test
    public void testGetAccessToken() throws Exception {
        String accessToken = TokenPool.getAccessToken("gh_36f3110ed079");
        Assert.assertNotNull(accessToken);
        System.out.println(accessToken);
    }
}
