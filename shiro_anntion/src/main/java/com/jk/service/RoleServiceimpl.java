package com.jk.service;

import com.jk.mapper.RoleBeanMapper;
import com.jk.model.RoleBean;
import com.jk.model.TreeBean;
import com.jk.model.UserRoleBean;
import com.jk.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Service
public class RoleServiceimpl implements RoleService {
    @Autowired
    private RoleBeanMapper roleBeanMapper;
    @Override
    public List<RoleBean> queryRole() {

        return roleBeanMapper.queryRole();
    }

    @Override
    public List<RoleBean> queryUserRole(Integer uid) {
        List<RoleBean> list1 =roleBeanMapper.queryRole();
        List<UserRoleBean> list2=roleBeanMapper.queryUserRole(uid);
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if(list1.get(i).getRoleid()==list2.get(j).getSrroleid()){
                    list1.get(i).setChecked(true);
                }
            }
        }
        return list1;
    }

    @Override
    public void saveUserRole(int uid, String rids) {
        roleBeanMapper.deleteUserRoleById(uid);
        String[] ridArr = rids.split(",");
        roleBeanMapper.saveUserRole(uid,ridArr);
    }

    public List<TreeBean> queryRoleTree(Integer rid, int pid) {
        List<TreeBean> tree1=roleBeanMapper.queryRoleTrees(pid);
        List<Integer> roleTrees=roleBeanMapper.queryRoleTreesById(rid);
		/*for (int i = 0; i < tree1.size(); i++) {
			for (int j = 0; j < roleTrees.size(); j++) {
				if(tree1.get(i).getId()==roleTrees.get(j)){
					tree1.get(i).setChecked(true);
				}
			}
		}*/
        if(tree1 !=null && tree1.size()>0){
            for (int i = 0; i < tree1.size(); i++) {
                List<TreeBean> tree2=queryRoleTree(rid,tree1.get(i).getId());
                tree1.get(i).setChildren(tree2);


                for (int j = 0; j < roleTrees.size(); j++) {
                    if(tree2.size()<=0 && tree1.get(i).getId()==roleTrees.get(j)){
                        tree1.get(i).setChecked(true);
                    }
                }
            }
        }


        return tree1;
    }

    @Override
    public void savaRoleTree(int rid, String[] mids) {
        roleBeanMapper.deleteTreeById(rid);
        roleBeanMapper.savaRoleTree(rid,mids);
    }

    @RequestMapping("toRoleTree")
    public String toRoleTree(Integer rid, Model model){
        model.addAttribute("rid",rid);
        return "toRoleQx";
    }

}
