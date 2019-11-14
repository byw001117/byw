package com.jk.mapper;

import com.jk.model.RoleBean;
import com.jk.model.TreeBean;
import com.jk.model.UserRoleBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleBeanMapper {
    int deleteByPrimaryKey(Integer roleid);

    int insert(RoleBean record);

    int insertSelective(RoleBean record);

    RoleBean selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(RoleBean record);

    int updateByPrimaryKey(RoleBean record);

    List<RoleBean> queryRole();

    List<UserRoleBean> queryUserRole(Integer uid);

    void deleteUserRoleById(int uid);

    void saveUserRole(@Param("uid") int uid, @Param("ridArr") String[] ridArr);

    //List<TreeBean> queryRoleTree(int pid);

    List<TreeBean> queryRoleTrees(@Param("pid") int pid);

    List<Integer> queryRoleTreesById(@Param("rid") int rid);

    void deleteTreeById(@Param("rid") int rid);

    void savaRoleTree(@Param("rid") int rid, @Param("mids") String[] mids);
}