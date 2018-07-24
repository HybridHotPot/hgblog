package com.huoguo.JsonBean;

import com.huoguo.bean.Article;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ArticleRecommend {
    private Integer id;

    private String title;

    private String time;

    private Integer pv;

    private String cover;

    private Integer userId;

    private String articlecategory;

    private String description;

    private ArrayList<String> label;

    private int commentNumber;

    public ArticleRecommend(Article e, String labels, int commentNumber,String articlecategory) {
        label=new ArrayList<>();
        id=e.getId();
        title=e.getTitle();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        time=sdf.format(e.getTime());
        pv=e.getPv();
        cover=e.getCover();
        userId=e.getUserId();
        this.articlecategory=articlecategory;
        description=e.getDescription();
        String[] s=labels.split(";");
        for(String tmp:s)
            label.add(tmp);
        this.commentNumber=commentNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getArticlecategory() {
        return articlecategory;
    }

    public void setArticlecategory(String articlecategory) {
        this.articlecategory = articlecategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getLabel() {
        return label;
    }

    public void setLabel(ArrayList<String> label) {
        this.label = label;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }
}
