package com.jk.model;

import java.io.Serializable;
import java.util.Date;


public class CarBean  implements Serializable {
    private static final long serialVersionUID = -7957055685004881107L;


    private Integer carid;

    private String carname;

    private String carsales;

    private Date cartime;

    private Integer typeid;

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
        this.carname = carname;
    }

    public String getCarsales() {
        return carsales;
    }

    public void setCarsales(String carsales) {
        this.carsales = carsales;
    }

    public Date getCartime() {
        return cartime;
    }

    public void setCartime(Date cartime) {
        this.cartime = cartime;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }
}