package com.miles.wechat.impl;

import com.miles.wechat.WeChatBaseTest;
import com.miles.wechat.core.TokenPool;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 测试获取AccessToken
 * Created by Michael on 2014/9/15.
 */
public class AccessTokenTest extends WeChatBaseTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testGetAccessToken() throws Exception {
        String accessToken = TokenPool.getAccessToken("gh_36f3110ed079");
        Assert.assertNotNull(accessToken);
        System.out.println(accessToken);
    }
}
