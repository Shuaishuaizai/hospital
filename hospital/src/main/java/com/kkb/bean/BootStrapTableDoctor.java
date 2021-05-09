package com.kkb.bean;

import com.kkb.util.DateFormatUtil;

public class BootStrapTableDoctor {
    private Integer dId;

    private String dName;

    private String dIdcar;

    private String dPhone;

    private String dTelphone;

    private String dSex;

    private String dBirthday;

    private Integer dAge;

    private String dEmail;

    private String dKeshi;

    private String dXueli;

    private String dDesc;

    private String dIntime;

    private Integer dState;

    public BootStrapTableDoctor(Doctor doctor){
        this.dId = doctor.getdId();
        this.dName = doctor.getdName();
        this.dIdcar = doctor.getdIdcar();
        this.dPhone = doctor.getdPhone();
        this.dTelphone = doctor.getdTelphone();
        switch (doctor.getdSex()) {
            case 0:this.dSex = "男";break;
            case 1:this.dSex = "女";break;
            default:this.dSex = "不明";break;
        }
        this.dBirthday = DateFormatUtil.format(doctor.getdBirthday());
        this.dAge = doctor.getdAge();
        this.dEmail = doctor.getdEmail();
        this.dKeshi = doctor.getdKeshi();
        this.dXueli = doctor.getdXueli();
        this.dDesc = doctor.getdDesc();
        this.dIntime = DateFormatUtil.format(doctor.getdIntime());
        this.dState = doctor.getdState();
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }



    public String getdIdcar() {
        return dIdcar;
    }

    public void setdIdcar(String dIdcard) {
        this.dIdcar = dIdcard;
    }

    public String getdPhone() {
        return dPhone;
    }

    public void setdPhone(String dPhone) {
        this.dPhone = dPhone;
    }

    public String getdTelphone() {
        return dTelphone;
    }

    public void setdTelphone(String dTelphone) {
        this.dTelphone = dTelphone;
    }


    public String getdSex() {
        return dSex;
    }

    public void setdSex(String dSex) {
        this.dSex = dSex;
    }

    public String getdBirthday() {
        return dBirthday;
    }

    public void setdBirthday(String dBirthday) {
        this.dBirthday = dBirthday;
    }

    public Integer getdAge() {
        return dAge;
    }

    public void setdAge(Integer dAge) {
        this.dAge = dAge;
    }

    public String getdEmail() {
        return dEmail;
    }

    public void setdEmail(String dEmail) {
        this.dEmail = dEmail;
    }

    public String getdKeshi() {
        return dKeshi;
    }

    public void setdKeshi(String dKeshi) {
        this.dKeshi = dKeshi;
    }

    public String getdXueli() {
        return dXueli;
    }

    public void setdXueli(String dXueli) {
        this.dXueli = dXueli;
    }

    public String getdDesc() {
        return dDesc;
    }

    public void setdDesc(String dDesc) {
        this.dDesc = dDesc;
    }

    public String getdIntime() {
        return dIntime;
    }

    public void setdIntime(String dIntime) {
        this.dIntime = dIntime;
    }

    public Integer getdState() {
        return dState;
    }

    public void setdState(Integer dState) {
        this.dState = dState;
    }
}