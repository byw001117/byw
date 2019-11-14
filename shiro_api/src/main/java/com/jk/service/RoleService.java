package com.jk.service;

import com.jk.model.RoleBean;
import com.jk.model.TreeBean;

import java.util.List;

public interface RoleService {
    List<RoleBean> queryRole();

    List<RoleBean> queryUserRole(Integer uid);

    void saveUserRole(int uid, String rids);

    List<TreeBean> queryRoleTree(Integer rid, int pid);

    void savaRoleTree(int rid, String[] mids);
}
