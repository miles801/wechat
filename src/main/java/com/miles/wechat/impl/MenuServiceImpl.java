package com.miles.wechat.impl;

import com.miles.wechat.api.AbstractMenuAdapter;
import com.miles.wechat.api.MenuService;
import com.miles.wechat.api.ResponseInfo;
import com.miles.wechat.api.WeChatUrl;
import com.miles.wechat.core.MenuAdapter;
import com.miles.wechat.core.RequestWrapper;
import com.miles.wechat.entity.Menu;
import com.miles.wechat.utils.SimpleRequest;
import org.apache.http.entity.StringEntity;
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author miles
 * @datetime 2014/5/21 2:16
 */
public class MenuServiceImpl implements MenuService {
    private Logger logger = Logger.getLogger(MenuServiceImpl.class);

    @Override
    public ResponseInfo createMenu(List<Menu> menus) {
        String url = RequestWrapper.getUrl(WeChatUrl.MENU_CREATE);
        AbstractMenuAdapter adapter = new MenuAdapter();
        String json = adapter.serialize(menus);
        StringEntity entity = null;
        try {
            entity = new StringEntity(json, "application/json", "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String result = SimpleRequest.doPost(url, entity);
        return RequestWrapper.getResponseInfo(result);
    }

    @Override
    public ResponseInfo clearMenu() {
        String url = RequestWrapper.getUrl(WeChatUrl.MENU_DELETE);
        String result = SimpleRequest.doGet(url);
        return RequestWrapper.getResponseInfo(result);
    }

    @Override
    public List<Menu> menuList() {
        String url = RequestWrapper.getUrl(WeChatUrl.MENU_GET);
        String result = SimpleRequest.doGet(url);
        ResponseInfo info = RequestWrapper.getResponseInfo(result);
        if (!info.isSuccess()) {
            logger.error(info.getErrorCode() + "--》" + info.getErrorMessage());
            return null;
        }
        AbstractMenuAdapter adapter = new MenuAdapter();
        return adapter.deserialize(result);
    }
}
