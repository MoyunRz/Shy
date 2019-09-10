package com.springmvc.entity;

import javax.xml.soap.Text;
import java.sql.Date;

public class EHoliday {

    private Integer id;
    private String  ename;
    private String  position;
    private Integer holiday;
    private Date    sdate;
    private Date    edate;
    private String    ps;

    public EHoliday() {
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

    public Integer getHoliday() {
        return holiday;
    }

    public void setHoliday(Integer holiday) {
        this.holiday = holiday;
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    @Override
    public String toString() {
        return "EHoliday{" +
                "id=" + id +
                ", ename='" + ename + '\'' +
                ", position='" + position + '\'' +
                ", holiday=" + holiday +
                ", sdate=" + sdate +
                ", edate=" + edate +
                ", ps='" + ps + '\'' +
                '}';
    }
}
