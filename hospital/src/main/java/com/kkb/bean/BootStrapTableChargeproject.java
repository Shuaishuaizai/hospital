package com.kkb.bean;

public class BootStrapTableChargeproject {
    private Integer chapId;

    private String chapName;

    private String chapMoney;

    public BootStrapTableChargeproject(Chargeproject c) {
        this.chapName=c.getChapName();
        this.chapId=c.getChapId();
        this.chapMoney =c.getChapMoney().toString();
    }

    @Override
    public String toString() {
        return "BootStrapTableChargeproject{" +
                "chapId=" + chapId +
                ", chapName='" + chapName + '\'' +
                ", chapMoney='" + chapMoney + '\'' +
                '}';
    }

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
        this.chapName = chapName;
    }

    public String getChapMoney() {
        return chapMoney;
    }

    public void setChapMoney(String chapMoney) {
        this.chapMoney = chapMoney;
    }

    public BootStrapTableChargeproject(Integer chapId, String chapName, String chapMoney) {
        this.chapId = chapId;
        this.chapName = chapName;
        this.chapMoney = chapMoney;
    }
}
