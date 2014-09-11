package com.miles.wechat.entity;

import com.google.gson.annotations.SerializedName;

/**
 * 上传多媒体后返回的上传信息
 *
 * @author miles
 * @datetime 2014/5/6 15:23
 */
public class UploadInfo extends GlobalCode {
    private String type;
    @SerializedName("media_id")
    private String mediaId;
    @SerializedName("created_at")
    private long createdTime;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }
}
