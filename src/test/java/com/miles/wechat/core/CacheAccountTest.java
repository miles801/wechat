package com.miles.wechat.core;

import com.miles.cache.CacheContainer;
import com.miles.wechat.impl.SimpleCacheAccount;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class CacheAccountTest {
    CacheContainer cacheContainer = null;

    @Before
    public void setUp() throws Exception {
        cacheContainer = CacheContainer.getInstance();
        PublicServiceLoader publicServiceLoader = PublicServiceLoader.getInstance();
        publicServiceLoader.setCacheAccount(new SimpleCacheAccount());

        WeChatEngine engine = WeChatEngine.newInstance();
    }

    @Test
    public void testGetCacheData() throws Exception {
        Map<String, Object> data = cacheContainer.getCachedData(CacheAccount.class);
        Assert.assertNotNull(data);
        Assert.assertTrue(!data.isEmpty());
    }
}