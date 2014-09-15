package com.miles.wechat.impl;

import com.miles.wechat.AbstractBasicTest;
import com.miles.wechat.api.FansGroupService;
import com.miles.wechat.core.WeChatEngine;
import com.miles.wechat.entity.FansGroup;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FansGroupServiceImplTest extends AbstractBasicTest {
    private FansGroupService fansGroupService;

    @Before
    public void setUp() throws Exception {
        WeChatEngine engine = WeChatEngine.newInstance();
        fansGroupService = engine.getFansGroupService();
    }

    @Test
    public void testCreateGroup() throws Exception {
        Assert.assertNotNull(fansGroupService);
        FansGroup group = fansGroupService.createGroup("同事");
        Assert.assertNotNull(group);
        Assert.assertEquals("同事", group.getName());
    }

    @Test
    public void testGroupList() throws Exception {
        List<FansGroup> groups = fansGroupService.groupList();
        Assert.assertNotNull(groups);
        Assert.assertTrue(groups.size() > 0);
    }

    @Test
    public void testUserInGroup() throws Exception {
        String openid = "oQ3C4uMUBlTeVHCCyw-QWfO0P-Cs";
        Integer group = fansGroupService.userInGroup(openid);
        Assert.assertNotNull(group);
    }

    @Test
    public void testRename() throws Exception {
        boolean result = fansGroupService.rename(104, "新名称");
        Assert.assertTrue(result);
    }

    @Test
    public void testMoveUserToGroup() throws Exception {
        String openid = "oQ3C4uMUBlTeVHCCyw-QWfO0P-Cs";
        boolean result = fansGroupService.moveUserToGroup(openid, 1);
        Assert.assertTrue(result);
    }
}