package com.huoguo.bean;

public class SystemMessage {
    private Integer id;

    private Byte isbroadcast;

    private String content;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getIsbroadcast() {
        return isbroadcast;
    }

    public void setIsbroadcast(Byte isbroadcast) {
        this.isbroadcast = isbroadcast;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}