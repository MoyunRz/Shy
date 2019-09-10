package com.springmvc.entity;

import java.sql.Date;

public class LifeSpend {

    private Integer id;
    private String useText;
    private float sum;
    private Date spendtime;

    public LifeSpend() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUseText() {
        return useText;
    }

    public void setUseText(String useText) {
        this.useText = useText;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public Date getSpendtime() {
        return spendtime;
    }

    public void setSpendtime(Date spendtime) {
        this.spendtime = spendtime;
    }


}
