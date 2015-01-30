package com.miles.cache;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class CacheContainerTest {
    CacheContainer cacheContainer = null;

    @Before
    public void setUp() throws Exception {
        cacheContainer = CacheContainer.getInstance();
        cacheContainer.register(CacheImpl.class, new CacheImpl());
    }

    @Test
    public void testGetCacheData() throws Exception {
        Map<String, Object> data = cacheContainer.getCachedData(CacheImpl.class);
        Assert.assertNotNull(data);
        Assert.assertTrue(!data.isEmpty());
    }

}