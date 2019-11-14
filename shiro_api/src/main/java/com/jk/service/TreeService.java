package com.jk.service;

import com.jk.model.TreeBean;

import java.util.List;

public interface TreeService {
    List<TreeBean> queryTree(int pid);
}
