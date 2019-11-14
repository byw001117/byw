package com.jk.controller;

import com.jk.model.RoleBean;
import com.jk.model.TreeBean;
import com.jk.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("toRole")
    public  String toRole(){
        return "toRole";
    }

    @RequestMapping("queryRole")
    @ResponseBody
    public HashMap queryRole(){
        List<RoleBean> roleList =roleService.queryRole();
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows",roleList);
        return map;
    }

    @RequestMapping("queryUserRole")

    public String queryUserRole(Integer uid, Model model){
        model.addAttribute("uid",uid);
        List<RoleBean> roleList=roleService.queryUserRole(uid);
        model.addAttribute("roles",roleList);
        return "toUserRole";
    }

    @RequestMapping("saveUserRole")
    @ResponseBody
    public String saveUserRole(int uid,String rids){
        roleService.saveUserRole(uid,rids);
        return "suc";
    }

    @RequestMapping("toRoleTree")
    public String toRoleTree(Integer rid, Model model, HttpServletRequest request){
        request.getSession().setAttribute("rid",rid);
        //model.addAttribute("rid",rid);
        return "toRoleQx";
    }

    @RequestMapping("queryRoleTrees")
    @ResponseBody
    public List<TreeBean> queryRoleTree(HttpServletRequest request){
        Integer rid = (Integer) request.getSession().getAttribute("rid");

        return  roleService.queryRoleTree(rid,-1);
    }


    @RequestMapping("savaRoleTree")
    @ResponseBody
    public String savaRoleTree(int rid,String[] mids){
        roleService.savaRoleTree(rid,mids);
        return "suc";

    }
}

