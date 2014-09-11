package com.miles.wechat.entity.message;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @author miles
 * @datetime 2014/5/23 10:46
 */
public class Article {
    private List<Item> items;

    @XmlElement(name = "item")
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
