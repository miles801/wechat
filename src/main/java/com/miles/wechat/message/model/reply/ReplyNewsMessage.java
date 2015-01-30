package com.miles.wechat.message.model.reply;

import com.miles.wechat.message.model.meta.ArticleItem;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * 回复图文消息
 *
 * @author Michael
 */
@XmlRootElement(name = "xml")
public class ReplyNewsMessage extends ReplyMessage {
    private Integer articleCount;
    private List<ArticleItem> articles;

    @XmlElementWrapper(name = "Articles")
    @XmlElement(name = "item")
    public List<ArticleItem> getArticle() {
        return articles;
    }

    public void setArticle(List<ArticleItem> articles) {
        this.articles = articles;
    }

    @XmlElement(name = "ArticleCount")
    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }


    /**
     * 添加图文内容
     *
     * @param title       图片标题
     * @param description 图片描述
     * @param url         点击图文要跳转的链接
     * @param picUrl      图片的链接：支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
     */
    public void addArticle(String title, String description, String url, String picUrl) {
        if (articles == null) {
            articles = new ArrayList<ArticleItem>();
        }
        ArticleItem item = new ArticleItem(title, description, url, picUrl);
        articles.add(item);
    }
}
