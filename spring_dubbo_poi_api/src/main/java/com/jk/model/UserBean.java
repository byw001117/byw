package com.jk.model;

import java.io.Serializable;
import java.util.Date;

public class UserBean  implements Serializable {
    private static final long serialVersionUID = -2146177603789361763L;
    private Integer userid;

    private String username;

    private Date usertime;

    private Integer usersex;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getUsertime() {
        return usertime;
    }

    public void setUsertime(Date usertime) {
        this.usertime = usertime;
    }

    public Integer getUsersex() {
        return usersex;
    }

    public void setUsersex(Integer usersex) {
        this.usersex = usersex;
    }
}