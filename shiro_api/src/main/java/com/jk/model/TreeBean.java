package com.jk.model;

import java.util.List;

public class TreeBean {
    private Integer id;

    private String text;

    private Integer pid;

    private String url;

    private List<TreeBean> children;


    private boolean checked = false;

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChildren(List<TreeBean> children) {
        this.children = children;
    }

    public List<TreeBean> getChildren() {
        return children;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Integer getPid() {
        return pid;
    }

    public String getUrl() {
        return url;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}