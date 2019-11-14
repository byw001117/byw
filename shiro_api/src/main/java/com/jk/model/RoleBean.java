package com.jk.model;

public class RoleBean {
    private Integer roleid;

    private String rolename;

    private boolean checked = false;

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isChecked() {
        return checked;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}