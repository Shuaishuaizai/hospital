package com.kkb.bean;

import javax.persistence.Table;

/**
 * @author xiaoyou
 *
 */
@Table(name = "chargeproject")
public class Chargeproject {
    private Integer chapId;

    private String chapName;

    private Double chapMoney;

    public Integer getChapId() {
        return chapId;
    }

    public void setChapId(Integer chapId) {
        this.chapId = chapId;
    }

    public String getChapName() {
        return chapName;
    }

    public void setChapName(String chapName) {
        this.chapName = chapName == null ? null : chapName.trim();
    }

    public Double getChapMoney() {
        return chapMoney;
    }

    public void setChapMoney(Double chapMoney) {
        this.chapMoney = chapMoney;
    }
}