package com.springmvc.entity;

import java.sql.Date;

public class Material {
    private Integer id;
    private String  mname;
    private Date    mdate;
    private float   price;
    private Integer number;
    private float   total;
    private Integer mstatus;
    private String  endaddress;
    private String  master;
    private String  ps;

    public Material() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getEndaddress() {
        return endaddress;
    }

    public void setEndaddress(String endaddress) {
        this.endaddress = endaddress;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Integer getMstatus() {
        return mstatus;
    }

    public void setMstatus(Integer mstatus) {
        this.mstatus = mstatus;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public Date getMdate() {
        return mdate;
    }

    public void setMdate(Date mdate) {
        this.mdate = mdate;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }
}
