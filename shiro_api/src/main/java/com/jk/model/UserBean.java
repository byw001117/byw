package com.jk.model;

public class UserBean {
    private Integer userid;

    private String username;

    private String userpwd;

    public Integer getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }
}