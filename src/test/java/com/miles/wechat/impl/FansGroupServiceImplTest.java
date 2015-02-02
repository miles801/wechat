package com.miles.wechat.impl;

import com.miles.wechat.WeChatBaseTest;
import com.miles.wechat.api.FansGroupService;
import com.miles.wechat.core.WeChatEngine;
import com.miles.wechat.entity.FansGroup;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FansGroupServiceImplTest extends WeChatBaseTest {
    private FansGroupService fansGroupService;

    private Logger logger = Logger.getLogger(FansGroupServiceImplTest.class);

    @Before
    public void setUp() throws Exception {
        WeChatEngine engine = WeChatEngine.newInstance();
        fansGroupService = engine.getFansGroupService();
    }

    @Test
    public void testCreateGroup() throws Exception {
        logger.info("测试创建粉丝组...");
        Assert.assertNotNull(fansGroupService);
        FansGroup group = fansGroupService.createGroup("同事");
        Assert.assertNotNull(group);
        Assert.assertEquals("同事", group.getName());
    }

    @Test
    public void testGroupList() throws Exception {
        logger.info("测试获取指定公众号的粉丝组列表...");
        List<FansGroup> groups = fansGroupService.groupList();
        Assert.assertNotNull(groups);
        Assert.assertTrue(groups.size() > 0);
    }

    @Test
    public void testUserInGroup() throws Exception {
        logger.info("测试查询指定粉丝所在的粉丝组的id...");
        String openid = "oQ3C4uMUBlTeVHCCyw-QWfO0P-Cs";
        Integer group = fansGroupService.userInGroup(openid);
        Assert.assertNotNull(group);
    }

    @Test
    public void testRename() throws Exception {
        logger.info("测试重命名粉丝组...");
        boolean result = fansGroupService.rename(104, "新名称");
        Assert.assertTrue(result);
    }

    @Test
    public void testMoveUserToGroup() throws Exception {
        logger.info("测试将指定粉丝移动到指定的粉丝组...");
        String openid = "oQ3C4uMUBlTeVHCCyw-QWfO0P-Cs";
        boolean result = fansGroupService.moveUserToGroup(openid, 1);
        Assert.assertTrue(result);
    }
}