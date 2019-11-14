package com.jk.mapper;

import com.jk.model.UserBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserBeanMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(UserBean record);

    int insertSelective(UserBean record);

    UserBean selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(UserBean record);

    int updateByPrimaryKey(UserBean record);

    List<UserBean> queryUser();

    void addUser(List<UserBean> list);
}