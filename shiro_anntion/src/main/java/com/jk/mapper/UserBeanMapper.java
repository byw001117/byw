package com.jk.mapper;

import com.jk.model.UserBean;

import java.util.List;

public interface UserBeanMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(UserBean record);

    int insertSelective(UserBean record);

    UserBean selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(UserBean record);

    int updateByPrimaryKey(UserBean record);

    List<UserBean> queryUser();


    UserBean queryuser(UserBean us);

    List<UserBean> login(String username);
}