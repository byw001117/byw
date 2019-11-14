package com.jk.service;

import com.jk.mapper.TreeBeanMapper;
import com.jk.model.TreeBean;
import com.jk.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeServiceImpl implements TreeService {
    @Autowired
    private TreeBeanMapper treeBeanMapper;



    @Override
    public List<TreeBean> queryTree(int pid) {
        List<TreeBean> list=treeBeanMapper.queryTree(pid);
        if(list!=null && list.size()>0){
            for (int i = 0; i < list.size(); i++) {
                List<TreeBean> list2=queryTree(list.get(i).getId());
                list.get(i).setChildren(list2);
            }
        }
        return list;
    }
}
