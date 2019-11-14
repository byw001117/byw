package com.jk.model;

import java.util.Date;

public class CarBean {
    private Integer carid;

    private String carname;

    private String carsales;

    private String cartime;

    private String cartype;

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname == null ? null : carname.trim();
    }

    public String getCarsales() {
        return carsales;
    }

    public void setCarsales(String carsales) {
        this.carsales = carsales == null ? null : carsales.trim();
    }

    public String getCartime() {
        return cartime;
    }

    public void setCartime(String cartime) {
        this.cartime = cartime;
    }

    public String getCartype() {
        return cartype;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype == null ? null : cartype.trim();
    }
}