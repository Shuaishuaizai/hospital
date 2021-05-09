package com.kkb.bean;

public class BootStrapTableBehospital {
    private Integer behId;

    private String behNursepeople;

    private String behPatbed;

    private String behAntecedent;

    private String behIllness;

    private String behCloseprice;

    private String behState;


    public BootStrapTableBehospital(Integer behId, String behNursepeople, String behPatbed, String behAntecedent) {
        this.behId = behId;
        this.behNursepeople = behNursepeople;
        this.behPatbed = behPatbed;
        this.behAntecedent = behAntecedent;

    }

    public BootStrapTableBehospital(Behospital b) {
        this.behId = b.getBehId();
        this.behNursepeople = b.getBehNursepeople();
        this.behPatbed = b.getBehPatbed();
        this.behAntecedent = b.getBehAntecedent().toString();
        this.behIllness = b.getBehIllness();
        this.behCloseprice = b.getBehCloseprice().toString();
        switch (b.getBehState()) {
            case 0:
                this.behState = "正常";
                break;
            default:
                this.behState = "禁用";
                break;
        }

    }

    public Integer getBehId() {
        return behId;
    }

    public void setBehId(Integer behId) {
        this.behId = behId;
    }

    public String getBehNursepeople() {
        return behNursepeople;
    }

    public void setBehNursepeople(String behNursepeople) {
        this.behNursepeople = behNursepeople;
    }

    public String getBehPatbed() {
        return behPatbed;
    }

    public void setBehPatbed(String behPatbed) {
        this.behPatbed = behPatbed;
    }

    public String getBehAntecedent() {
        return behAntecedent;
    }

    public void setBehAntecedent(String behAntecedent) {
        this.behAntecedent = behAntecedent;
    }

    public String getBehIllness() {
        return behIllness;
    }

    public void setBehIllness(String behIllness) {
        this.behIllness = behIllness;
    }

    public String getBehCloseprice() {
        return behCloseprice;
    }

    public void setBehCloseprice(String behCloseprice) {
        this.behCloseprice = behCloseprice;
    }

    public String getBehState() {
        return behState;
    }

    public void setBehState(String behState) {
        this.behState = behState;
    }

    @Override
    public String toString() {
        return "BootStrapTableBehospital{" +
                "behId=" + behId +
                ", behNursepeople='" + behNursepeople + '\'' +
                ", behPatbed='" + behPatbed + '\'' +
                ", behAntecedent='" + behAntecedent + '\'' +
                ", behIllness='" + behIllness + '\'' +
                ", behCloseprice='" + behCloseprice + '\'' +
                ", behState='" + behState + '\'' +
                '}';
    }
}
