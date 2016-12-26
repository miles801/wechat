package com.miles.wechat.api;

import com.miles.wechat.entity.CustomerServer;

import java.io.File;

/**
 * 客服接口
 *
 * @author Michael
 */
public interface CustomerServerService {

    /**
     * 新增客服
     *
     * @param customerServer 客服对象
     */
    ResponseInfo add(CustomerServer customerServer);


    /**
     * 更新客服信息
     *
     * @param customerServer 客服对象
     */
    ResponseInfo update(CustomerServer customerServer);

    /**
     * 删除客服
     *
     * @param customerServer 客服对象
     */
    ResponseInfo delete(CustomerServer customerServer);

    /**
     * 设置客服号的头像
     *
     * @param account 客服的账号
     * @param file    客服头像的图片的文件
     */
    ResponseInfo setHeadImg(String account, File file);




}
