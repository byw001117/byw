package com.jk.mapper;

import com.jk.model.TreeBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TreeBeanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TreeBean record);

    int insertSelective(TreeBean record);

    TreeBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TreeBean record);

    int updateByPrimaryKey(TreeBean record);

    List<TreeBean> queryTree(int pid);
}