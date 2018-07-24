package com.huoguo.JsonBean;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 文章详细页面对应的bean
 */
public class ArticleDetail {
    private String title;
    private String time;
    private String pv;
    private String article;
    private ArrayList<String> label;
    private ArrayList<String> articleCategory;

    public ArticleDetail(String title, String[] labels, String[] categorys, String time, String pv, String article) {
        this.title=title;
        this.label=new ArrayList<String>(Arrays.asList(labels));
        this.articleCategory=new ArrayList<String>(Arrays.asList(categorys));
        this.time=time;
        this.pv=pv;
        this.article=article;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPv() {
        return pv;
    }

    public void setPv(String pv) {
        this.pv = pv;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public ArrayList<String> getLabel() {
        return label;
    }

    public void setLabel(ArrayList<String> label) {
        this.label = label;
    }

    public ArrayList<String> getArticleCategory() {
        return articleCategory;
    }

    public void setArticleCategory(ArrayList<String> articleCategory) {
        this.articleCategory = articleCategory;
    }
}
