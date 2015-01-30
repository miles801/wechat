package com.miles.wechat.core;

import com.miles.cache.CacheContainer;
import com.miles.wechat.impl.SimpleCacheAccount;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class CacheAccessTokenTest {
    CacheContainer cacheContainer = CacheContainer.getInstance();

    @Before
    public void setUp() throws Exception {
        PublicServiceLoader publicServiceLoader = PublicServiceLoader.getInstance();
        publicServiceLoader.setCacheAccount(new SimpleCacheAccount());

        WeChatEngine.newInstance();
    }

    @Test
    public void testGetAccessToken() throws Exception {
        Map<String, Object> cachedData = cacheContainer.getCachedData(CacheAccessToken.class);
        Assert.assertNotNull(cachedData);
        Assert.assertEquals(false, cachedData.isEmpty());
        Assert.assertNotNull(cachedData.get("gh_36f3110ed079"));
        System.out.println(cachedData);
        Thread.sleep(20000);
        System.out.println(cachedData);
    }
}