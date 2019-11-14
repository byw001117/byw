package com.jk.controller;

import com.jk.model.RoleBean;
import com.jk.model.UserBean;
import com.jk.service.UserService;
import com.jk.utils.CheckImgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class Usercontroller {
    @Autowired
    private UserService userService;



   @RequestMapping("toShow")
    public String toShow(){

       return  "show";
    }

    @RequestMapping("toUser")
    public  String toUser(){
       return "toUser";
    }


    @RequestMapping("queryUser")
    @ResponseBody
    public HashMap queryUser(){
        List<UserBean> userList = userService.queryUser();
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows",userList);
        return map;
    }

    @RequestMapping("toLogin")
    public  String toLogin(){
        return "login";
    }

    @RequestMapping("getCode")
    @ResponseBody
    public void getCode(HttpServletRequest request,HttpServletResponse response) throws Exception{
        CheckImgUtil.checkImg(request, response);
    }

    @RequestMapping("queryuser")
    @ResponseBody
    public String queryuser(UserBean us){
        UserBean u = userService.queryuser(us);
        if (u!=null && u.getUsername().equals(us.getUsername())) {
            if (us.getUserpwd()=="") {
                return "1";
            }
        }
        if (u==null) {
            return "2";
        }
        if(u!=null){
            if (u.getUsername().equals(us.getUsername()) && u.getUserpwd().equals(us.getUserpwd())) {
                return "3";
            }
        }
        return "4";
    }
    @RequestMapping("login")
    @ResponseBody
    public Integer login(UserBean u,String code,HttpServletRequest request){
        Map<String,Object> map = userService.login(u);
        String sessionCode = request.getSession().getAttribute("checkcode").toString();
        if(!sessionCode.equalsIgnoreCase(code)){
            map.put("flag", 666);
        }
        UserBean userObj = (UserBean) map.get("userObj");
        if (userObj!=null) {
            request.getSession().setAttribute("loginuser", userObj);
        }
        return (Integer) map.get("flag");
    }





}
