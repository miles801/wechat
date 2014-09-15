package com.miles.wechat.impl;

import com.miles.wechat.AbstractBasicTest;
import com.miles.wechat.core.Configuration;
import com.miles.wechat.core.TokenPool;
import junit.framework.Assert;
import org.junit.Test;

/**
 * 测试获取AccessToken
 * Created by Michael on 2014/9/15.
 */
public class AccessTokenTest extends AbstractBasicTest{

    @Test
    public void testGetAccessToken() throws Exception {
        String accessToken = TokenPool.getAccessToken(Configuration.getInstance().getWcid());
        Assert.assertNotNull(accessToken);
        System.out.println(accessToken);
    }
}
