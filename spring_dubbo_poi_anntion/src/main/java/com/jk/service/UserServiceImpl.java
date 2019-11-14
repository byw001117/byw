package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.UserBeanMapper;
import com.jk.model.UserBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service(version = "1.0")
public class UserServiceImpl implements  UserService{
    @Autowired
    private UserBeanMapper userBeanMapper;

    @Override
    public List<UserBean> queryUser() throws InterruptedException{
        List<UserBean> list = userBeanMapper.queryUser();
        return list;
    }

    @Override
    public void addUser(List<UserBean> list) {
        userBeanMapper.addUser(list);
    }
}
