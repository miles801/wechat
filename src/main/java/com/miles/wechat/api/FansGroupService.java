package com.miles.wechat.api;

import com.miles.wechat.entity.FansGroup;

import java.util.List;

/**
 * @author miles
 * @datetime 2014/5/21 1:51
 */
public interface FansGroupService {

    /**
     * 创建粉丝组
     *
     * @param groupName 粉丝组名称
     * @return 包含id的组对象
     */
    FansGroup createGroup(String groupName);

    /**
     * 获得粉丝组列表
     *
     * @return 粉丝组集合
     */
    List<FansGroup> groupList();


    /**
     * 查询用户所属的用户组
     *
     * @param openId 粉丝openId
     * @return 所属组的id
     */
    Integer userInGroup(String openId);

    /**
     * 重命名分组
     *
     * @param groupId 组的id
     * @param newName 组的新名称
     * @return true/false
     */
    boolean rename(int groupId, String newName);

    /**
     * 移动粉丝到指定组
     *
     * @param openId  粉丝的openId
     * @param groupId 组的id
     * @return 是否成功
     */
    boolean moveUserToGroup(String openId, int groupId);
}
