package com.miles.wechat.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.miles.wechat.api.FansGroupService;
import com.miles.wechat.api.ResponseInfo;
import com.miles.wechat.api.WeChatUrl;
import com.miles.wechat.core.RequestError;
import com.miles.wechat.core.RequestException;
import com.miles.wechat.core.RequestWrapper;
import com.miles.wechat.entity.FansGroup;
import com.miles.wechat.utils.GsonHelper;
import com.miles.wechat.utils.SimpleRequest;
import com.miles.wechat.utils.StringUtils;
import org.apache.http.entity.StringEntity;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author miles
 * @datetime 2014/5/21 20:46
 */
public class FansGroupServiceImpl implements FansGroupService {
    @Override
    public FansGroup createGroup(String groupName) {
        if (StringUtils.isEmpty(groupName)) {
            throw new IllegalArgumentException("创建粉丝组时，没有指定组的名称!");
        }
        String url = RequestWrapper.getUrl(WeChatUrl.FANS_GROUP_CREATE);
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("group", GsonHelper.addElement("name", groupName));
        StringEntity entity = null;
        try {
            entity = new StringEntity(jsonObject.toString(), "application/json", "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String result = SimpleRequest.doPost(url, entity);
        ResponseInfo info = RequestWrapper.getResponseInfo(result);
        if (!info.isSuccess()) {
            throw new RequestException(new RequestError(info.getInfo().getErrorCode(), info.getInfo().getErrorMessage()));
        }
        JsonObject group = GsonHelper.fromJson(result, JsonObject.class);
        JsonObject groupObject = group.get("group").getAsJsonObject();
        return wrap(groupObject);
    }

    @Override
    public List<FansGroup> groupList() {
        String url = RequestWrapper.getUrl(WeChatUrl.FANS_GROUP_LIST);
        String result = SimpleRequest.doGet(url);
        ResponseInfo info = RequestWrapper.getResponseInfo(result);
        if (!info.isSuccess()) {
            throw new RequestException(new RequestError(info.getInfo().getErrorCode(), info.getInfo().getErrorMessage()));
        }
        JsonObject data = GsonHelper.fromJson(result, JsonObject.class);
        JsonArray array = data.get("groups").getAsJsonArray();
        List<FansGroup> groups = new ArrayList<FansGroup>();
        Iterator<JsonElement> iterator = array.iterator();
        while (iterator.hasNext()) {
            JsonElement element = iterator.next();
            FansGroup foo = wrap(element.getAsJsonObject());
            if (foo != null) {
                groups.add(foo);
            }
        }
        return groups;
    }

    @Override
    public Integer userInGroup(String openId) {
        if (StringUtils.isEmpty(openId)) {
            throw new IllegalArgumentException("查询粉丝所属用户组时,没有获得粉丝的openId!");
        }
        String url = RequestWrapper.getUrl(WeChatUrl.FANS_IN_GROUP);
        JsonObject jsonObject = GsonHelper.addElement("openid", openId);
        StringEntity entity = null;
        try {
            entity = new StringEntity(jsonObject.toString(), "application/json", "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String result = SimpleRequest.doPost(url, entity);
        ResponseInfo info = RequestWrapper.getResponseInfo(result);
        if (!info.isSuccess()) {
            throw new RequestException(new RequestError(info.getInfo().getErrorCode(), info.getInfo().getErrorMessage()));
        }
        JsonObject json = GsonHelper.fromJson(result, JsonObject.class);
        if (json.get("groupid") != null) {
            return json.get("groupid").getAsInt();
        }
        return null;
    }

    @Override
    public boolean rename(int groupId, String newName) {
        if (StringUtils.isEmpty(newName)) {
            throw new IllegalArgumentException("重命名用户组时,没有指定组的名称!");
        }
        String url = RequestWrapper.getUrl(WeChatUrl.FANS_GROUP_RENAME);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", groupId);
        jsonObject.addProperty("name", newName);
        JsonObject object = new JsonObject();
        object.add("group", jsonObject);
        StringEntity entity = null;
        try {
            entity = new StringEntity(jsonObject.toString(), "application/json", "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String result = SimpleRequest.doPost(url, entity);
        ResponseInfo info = RequestWrapper.getResponseInfo(result);
        return info.isSuccess();
    }

    @Override
    public boolean moveUserToGroup(String openId, int groupId) {
        if (StringUtils.isEmpty(openId)) {
            throw new IllegalArgumentException("移动粉丝所属组时,没有获得粉丝的openId!");
        }
        String url = RequestWrapper.getUrl(WeChatUrl.FANS_GROUP_MOVE);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("openid", openId);
        jsonObject.addProperty("to_groupid", groupId);
        StringEntity entity = null;
        try {
            entity = new StringEntity(jsonObject.toString(), "application/json", "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String result = SimpleRequest.doPost(url, entity);
        ResponseInfo info = RequestWrapper.getResponseInfo(result);
        return info.isSuccess();
    }

    public FansGroup wrap(JsonObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        FansGroup fansGroup = new FansGroup();
        fansGroup.setId(jsonObject.get("id").getAsInt());
        fansGroup.setName(jsonObject.get("name").getAsString());
        if (jsonObject.get("count") != null) {
            fansGroup.setCount(jsonObject.get("count").getAsInt());
        }
        return fansGroup;
    }
}
