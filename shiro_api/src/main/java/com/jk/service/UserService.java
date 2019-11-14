package com.jk.service;

import com.jk.model.UserBean;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<UserBean> queryUser();


    UserBean queryuser(UserBean us);

    Map<String, Object> login(UserBean u);
}
