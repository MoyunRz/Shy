package com.springmvc.entity;

import java.sql.Date;

public class Account {
    private Integer id;
    private String ename;
    private String position;
    private float wage;
    private Date enddate;
    private Integer wstatus;

    public Account() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getWage() {
        return wage;
    }

    public void setWage(float wage) {
        this.wage = wage;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Integer getWstatus() {
        return wstatus;
    }

    public void setWstatus(Integer wstatus) {
        this.wstatus = wstatus;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", ename='" + ename + '\'' +
                ", position='" + position + '\'' +
                ", wage=" + wage +
                ", enddate=" + enddate +
                ", wstatus=" + wstatus +
                '}';
    }
}
