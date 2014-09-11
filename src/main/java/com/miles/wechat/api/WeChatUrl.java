package com.miles.wechat.api;

/**
 * 微信公众平台对外提供的接口，与PlaceholderFormat联合使用
 *
 * @author miles
 * @datetime 2014/5/14 9:56
 */
public interface WeChatUrl {

    String HOME = "https://mp.weixin.qq.com/";

    String LOGIN = "https://mp.weixin.qq.com/cgi-bin/login?lang=zh_CN";

    String ALL_INFO = "https://mp.weixin.qq.com/advanced/advanced?action=dev&t=advanced/dev&token=${1}&lang=zh_CN&f=json";
    /**
     * 获取access_token
     */
    String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=${1}&secret=${2}";

    /**
     * 创建菜单
     */
    String MENU_CREATE = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=${1}";

    /**
     * 获取菜单
     */
    String MENU_GET = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=${1}";
    /**
     * 清空菜单
     */
    String MENU_DELETE = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=${1}";

    /**
     * 获取粉丝基本信息
     */
    String FANS_INFO = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=${1}&openid=${2}&lang=${3}";

    /**
     * 获取粉丝列表
     */
    String FANS_LIST = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=${1}&next_openid=${2}";

    /**
     * 创建粉丝组
     */
    String FANS_GROUP_CREATE = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=${1}";

    /**
     * 查询所有粉丝组
     */
    String FANS_GROUP_LIST = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=${1}";

    /**
     * 查询粉丝所在的组
     */
    String FANS_IN_GROUP = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=${1}";

    /**
     * 重命名粉丝组
     */
    String FANS_GROUP_RENAME = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=${1}";

    /**
     * 移动用户所属的分组
     */
    String FANS_GROUP_MOVE = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=${1}";

    /**
     * 微信登录路径
     */
    String WECHAT_LOGIN_URL = "https://mp.weixin.qq.com/cgi-bin/login?lang=zh_CN";

    /**
     * 微信首页登录路径
     */
    String WECHAT_INDEX_URL = "https://mp.weixin.qq.com/";

    /**
     * 获取微信个人信息访问路径
     */
    String WECHAT_BASE_DATA = "https://mp.weixin.qq.com/cgi-bin/settingpage?t=setting/index&action=index&lang=zh_CN&token=${1}";

    /**
     * 群发
     */
    String SEND_TO_GROUP = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=${1}";

    /**
     * 给指定的一组用户发送
     */
    String SEND_TO_USER = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=${1}";

    /**
     * 上传多媒体文件:第一个参数为access_token，第二个参数为文件的类型
     */
    String UPLOAD = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=${1}&type=${2}";

    /**
     * 下载多媒体文件：第一个参数为access_token，第二个参数为媒体的id
     */
    String DOWNLOAD = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=${1}&media_id=${2}";
}
