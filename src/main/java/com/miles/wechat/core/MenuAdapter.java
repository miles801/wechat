package com.miles.wechat.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.miles.wechat.api.AbstractMenuAdapter;
import com.miles.wechat.entity.Menu;

import java.util.List;

/**
 * 用于将本地数据和微信数据进行转换
 *
 * @author miles
 * @datetime 2014/5/15 14:08
 */
public class MenuAdapter implements AbstractMenuAdapter {
    public List<Menu> deserialize(String wcMenuJson) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        DeserializeTemp temp = gson.fromJson(wcMenuJson, DeserializeTemp.class);
        if (temp == null || temp.getMenuTemp() == null) {
            return null;
        }
        return temp.getMenuTemp().getButtons();
    }

    /**
     * 将菜单集合转成json
     *
     * @param menus
     * @return
     */
    public String serialize(List<Menu> menus) {
        MenuTemp temp = new MenuTemp();
        temp.setButtons(menus);
        Gson gson = new Gson();
        return gson.toJson(temp);
    }
}

/**
 * 为了方便解析而构建的临时对象
 */
class DeserializeTemp {
    @SerializedName("menu")
    private MenuTemp menuTemp;

    public MenuTemp getMenuTemp() {
        return menuTemp;
    }

    public void setMenuTemp(MenuTemp menuTemp) {
        this.menuTemp = menuTemp;
    }
}

/**
 * 为了方便解析而构建的临时对象
 */
class MenuTemp {
    @SerializedName("button")
    private List<Menu> buttons;

    public List<Menu> getButtons() {
        return buttons;
    }

    public void setButtons(List<Menu> buttons) {
        this.buttons = buttons;
    }
}
