package com.miles.wechat.message.model.send;

import com.miles.wechat.message.model.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael
 */
public class News {
    @NotNull
    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public void addArticle(Article article) {
        if (articles == null) {
            articles = new ArrayList<Article>();
        }
        articles.add(article);
    }
}
