package com.kkb.bean;

public class BootStrapTableRole {
    private Integer rId;
    private String rName;

    private String rState;

    @Override
    public String toString() {
        return "BootStrapTableRole{" +
                "rId=" + rId +
                ", rName='" + rName + '\'' +
                ", rState='" + rState + '\'' +
                '}';
    }

    public BootStrapTableRole(Integer rId, String rName, String rState) {
        this.rId = rId;
        this.rName = rName;
        this.rState = rState;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getrState() {
        return rState;
    }

    public void setrState(String rState) {
        this.rState = rState;
    }
}
