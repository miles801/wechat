package com.miles.wechat.core;

import com.miles.cache.CacheContainer;
import com.miles.wechat.WeChatBaseTest;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class CacheAccountTest extends WeChatBaseTest {
    CacheContainer cacheContainer = null;

    @Before
    public void setUp() throws Exception {
        cacheContainer = CacheContainer.getInstance();
    }

    @Test
    public void testGetCacheData() throws Exception {
        Map<String, Object> data = cacheContainer.getCachedData(CacheAccount.class);
        Assert.assertNotNull(data);
        Assert.assertTrue(!data.isEmpty());
    }
}