package com.miles.wechat.utils;

import com.miles.wechat.api.MultiMediaType;

/**
 * @author miles
 */
public class MultiMediaHelper {
    private static final String IMG_JPG = "image/jpeg";
    private static final String IMG_THUMB = "image/thumb";
    private static final String VOICE_AMR = "audio/amr";
    private static final String VOICE_MP3 = "audio/mpeg";
    private static final String VIDEO_MP4 = "video/mpeg";

    /**
     * 根据文件类型获得微信所支持的多媒体类型
     *
     * @param type 文件类型
     * @return 文件类型对应的多媒体类型
     */
    public static MultiMediaType getFileType(String type) {
        if (StringUtils.isEmpty(type)) {
            throw new IllegalArgumentException("没有得到文件类型!");
        }
        //JPG
        if (IMG_JPG.equals(type)) {
            return MultiMediaType.IMAGE;
        }
        //THUMB
        if (IMG_THUMB.equals(type)) {
            return MultiMediaType.THUMB;
        }
        //VIDEO
        if (VIDEO_MP4.equals(type)) {
            return MultiMediaType.VIDEO;
        }
        //VOICE
        if (VOICE_MP3.equals(type) || VOICE_AMR.equals(type)) {
            return MultiMediaType.VOICE;
        }
        return null;
    }
}
