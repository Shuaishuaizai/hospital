package com.kkb.bean;

public class BootStrapTableBC {
    private Integer behId;
    private String nursepeople;
    private String chapName;
    private Double chapMoney;


    @Override
    public String toString() {
        return "BootstrapTableBC{" +
                "behId=" + behId +
                ", nursepeople='" + nursepeople + '\'' +
                ", chapName='" + chapName + '\'' +
                ", chapMoney='" + chapMoney + '\'' +
                '}';
    }

    public BootStrapTableBC(Integer behId, String nursepeople, String chapName, Double chapMoney) {
        this.behId = behId;
        this.nursepeople = nursepeople;
        this.chapName = chapName;
        this.chapMoney = chapMoney;
    }

    public void setBehId(Integer behId) {
        this.behId = behId;
    }

    public void setNursepeople(String nursepeople) {
        this.nursepeople = nursepeople;
    }

    public void setChapName(String chapName) {
        this.chapName = chapName;
    }

    public void setChapMoney(Double chapMoney) {
        this.chapMoney = chapMoney;
    }

    public Integer getBehId() {
        return behId;
    }

    public String getNursepeople() {
        return nursepeople;
    }

    public String getChapName() {
        return chapName;
    }

    public Double getChapMoney() {
        return chapMoney;
    }
}
