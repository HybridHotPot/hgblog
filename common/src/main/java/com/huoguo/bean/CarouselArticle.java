package com.huoguo.bean;

public class CarouselArticle {
    private Integer id;

    private String simpledesc;

    private String cover;

    private Integer articleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSimpledesc() {
        return simpledesc;
    }

    public void setSimpledesc(String simpledesc) {
        this.simpledesc = simpledesc == null ? null : simpledesc.trim();
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}