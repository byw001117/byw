package com.jk.service;

import com.jk.mapper.UserBeanMapper;
import com.jk.model.UserBean;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserBeanMapper userBeanMapper;
    @Override
    public List<UserBean> queryUser() {
        return userBeanMapper.queryUser();
    }

    @Override
    public UserBean queryuser(UserBean us) {

        return userBeanMapper.queryuser(us);
    }

    @Override
    public Map<String, Object> login(UserBean u) {
        int flag=1;
        HashMap<String, Object> map = new HashMap<>();
        List<UserBean> list=userBeanMapper.login(u.getUsername());
        if(list!=null && list.size()>0){
            UserBean userObj=list.get(0);
            flag=2;
            if(u.getUserpwd().equals(userObj.getUserpwd())){
                flag=3;
                map.put("userObj",userObj);
            }

        }
        map.put("flag",flag);
        return map;
    }


}
