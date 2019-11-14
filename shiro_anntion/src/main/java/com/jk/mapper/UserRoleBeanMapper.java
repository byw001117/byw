package com.jk.mapper;

import com.jk.model.UserRoleBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleBeanMapper {
    int deleteByPrimaryKey(Integer urid);

    int insert(UserRoleBean record);

    int insertSelective(UserRoleBean record);

    UserRoleBean selectByPrimaryKey(Integer urid);

    int updateByPrimaryKeySelective(UserRoleBean record);

    int updateByPrimaryKey(UserRoleBean record);
}