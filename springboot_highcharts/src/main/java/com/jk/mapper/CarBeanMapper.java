package com.jk.mapper;

import com.jk.model.CarBean;

import java.util.List;
import java.util.Map;

public interface CarBeanMapper {

    List<Map<String, Object>> queryCar();

    List<Map<String, Object>> queryCarAll();
}