package com.miles.wechat.api;

/**
 * 微信公众平台对外提供的接口，与PlaceholderFormat联合使用
 *
 * @author miles
 * @datetime 2014/5/14 9:56
 */
public interface WeChatUrl {

    public static final String HOME = "wechat.url.home";
    public static final String LOGIN = "wechat.url.login";
    public static final String TOKEN_URL = "wechat.url.accessToken";
    public static final String WECHAT_BASE_DATA = "wechat.url.baseinfo";
    public static final String MENU_CREATE = "wechat.url.menu.create";
    public static final String MENU_GET = "wechat.url.menu.get";
    public static final String MENU_DELETE = "wechat.url.menu.clear";
    public static final String FANS_INFO = "wechat.url.fans.info";
    public static final String FANS_LIST = "wechat.url.fans.list";
    public static final String FANS_GROUP_CREATE = "wechat.url.fansgroup.create";
    public static final String FANS_GROUP_LIST = "wechat.url.fansgroup.list";
    public static final String FANS_IN_GROUP = "wechat.url.fansgroup.in";
    public static final String FANS_GROUP_RENAME = "wechat.url.fansgroup.rename";
    public static final String FANS_GROUP_MOVE = "wechat.url.fansgroup.move";
    public static final String SEND_TO_GROUP = "wechat.url.sendmsg.all";
    public static final String SEND_TO_USER = "wechat.url.sendmsg.group";
    public static final String UPLOAD = "wechat.url.file.upload";
    public static final String DOWNLOAD = "wechat.url.file.download";
    public static final String UPLOAD_NEWS = "wechat.url.upload.news";
    public static final String UPLOAD_VIDEO = "wechat.url.upload.video";
    /**
     * 删除群发
     */
    public static final String MASS_DELETE = "wechat.url.mass.delete";
    /**
     * 群发预览
     */
    public static final String MASS_PREVIEW = "wechat.url.mass.preview";
    /**
     * 群发状态
     */
    public static final String MASS_STATUS = "wechat.url.mass.status";

}
