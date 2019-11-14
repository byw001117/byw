package com.jk.mapper;

import com.jk.model.TreeRoleBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TreeRoleBeanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TreeRoleBean record);

    int insertSelective(TreeRoleBean record);

    TreeRoleBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TreeRoleBean record);

    int updateByPrimaryKey(TreeRoleBean record);
}