package com.jk.service;

import com.jk.mapper.CarBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarBeanMapper carBeanMapper;

    @Override
    public List<Map<String, Object>> queryCar() {
        return carBeanMapper.queryCar();
    }

    @Override
    public List<Map<String, Object>> queryCarAll() {
        return carBeanMapper.queryCarAll();
    }
}
