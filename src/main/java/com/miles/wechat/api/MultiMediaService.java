package com.miles.wechat.api;


import com.miles.wechat.entity.UploadInfo;

import java.io.File;

/**
 * 微信的多媒体服务
 *
 * @author miles
 * @datetime 2014/5/6 15:20
 */
public interface MultiMediaService {

    /**
     * 上传附件
     *
     * @param file 文件
     * @param type 文件类型
     * @return 上传结果
     */
    UploadInfo upload(File file, MultiMediaType type);


    /**
     * 上传图文
     *
     * @param newsJson 图文消息的json字符串
     * @return 上传结果
     */
    UploadInfo uploadNews(String newsJson);

    /**
     * 上传视频
     *
     * @param videoJson 视频消息的json字符串
     * @return 上传结果
     */
    UploadInfo uploadVideo(String videoJson);

    /**
     * 下载附件，返回File对象（该文件会保存到临时目录中）
     *
     * @param mediaId   多媒体id
     * @param directory 下载下来的附件要存放的目录
     * @return 文件
     */
    File download(String mediaId, String directory);

    /**
     * 根据多媒体的id获取访问地址
     *
     * @param mediaId 上传到微信的多媒体id
     * @return 访问地址
     */
    String mediaUrl(String mediaId);
}
