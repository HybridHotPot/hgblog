package com.huoguo.bean;

import java.util.Date;

public class Log {
    private Integer id;

    private String url;

    private Date time;

    private String ip;

    private String username;

    private Byte issuccess;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Byte getIssuccess() {
        return issuccess;
    }

    public void setIssuccess(Byte issuccess) {
        this.issuccess = issuccess;
    }
}