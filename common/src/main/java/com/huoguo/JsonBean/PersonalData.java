package com.huoguo.JsonBean;

public class PersonalData {
    private String name;
    private String picture;
    private String articleNumber;
    private String fansNumber;
    private String followNumber;

    public PersonalData(String nickname, String picture, Integer articlenumber, Integer fansnumber, int followNumber) {
        this.name=nickname;
        this.picture=picture;
        this.articleNumber=articlenumber+"";
        this.fansNumber=fansnumber+"";
        this.followNumber=followNumber+"";
    }

    public PersonalData(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    public String getFansNumber() {
        return fansNumber;
    }

    public void setFansNumber(String fansNumber) {
        this.fansNumber = fansNumber;
    }

    public String getFollowNumber() {
        return followNumber;
    }

    public void setFollowNumber(String followNumber) {
        this.followNumber = followNumber;
    }
}
