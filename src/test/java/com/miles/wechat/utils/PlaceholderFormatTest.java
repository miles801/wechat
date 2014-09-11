package com.miles.wechat.utils;

import com.miles.wechat.api.WeChatUrl;
import com.miles.wechat.core.RequestWrapper;
import junit.framework.TestCase;

public class PlaceholderFormatTest extends TestCase {

    public void testFormat() throws Exception {
        String url = RequestWrapper.getUrl(WeChatUrl.FANS_LIST, "");
    }
}