package com.kkb.bean;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
/**
 * @author xiaoyou
 *
 */
@Table(name = "doctor")
public class Doctor {
    @Id
    private Integer dId;

    private String dName;

    private String dIdcar;

    private String dPhone;

    private String dTelphone;

    private Integer dSex;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dBirthday;

    private Integer dAge;

    private String dEmail;

    private String dKeshi;

    private String dXueli;

    private String dDesc;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dIntime;

    private Integer dState;

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getdIdcar() {
        return dIdcar;
    }

    public void setdIdcar(String dIdcar) {
        this.dIdcar = dIdcar == null ? null : dIdcar.trim();
    }

    public String getdPhone() {
        return dPhone;
    }

    public void setdPhone(String dPhone) {
        this.dPhone = dPhone == null ? null : dPhone.trim();
    }

    public String getdTelphone() {
        return dTelphone;
    }

    public void setdTelphone(String dTelphone) {
        this.dTelphone = dTelphone == null ? null : dTelphone.trim();
    }

    public Integer getdSex() {
        return dSex;
    }

    public void setdSex(Integer dSex) {
        this.dSex = dSex;
    }

    public Date getdBirthday() {
        return dBirthday;
    }

    public void setdBirthday(Date dBirthday) {
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
        this.dEmail = dEmail == null ? null : dEmail.trim();
    }

    public String getdKeshi() {
        return dKeshi;
    }

    public void setdKeshi(String dKeshi) {
        this.dKeshi = dKeshi == null ? null : dKeshi.trim();
    }

    public String getdXueli() {
        return dXueli;
    }

    public void setdXueli(String dXueli) {
        this.dXueli = dXueli == null ? null : dXueli.trim();
    }

    public String getdDesc() {
        return dDesc;
    }

    public void setdDesc(String dDesc) {
        this.dDesc = dDesc == null ? null : dDesc.trim();
    }

    public Date getdIntime() {
        return dIntime;
    }

    public void setdIntime(Date dIntime) {
        this.dIntime = dIntime;
    }

    public Integer getdState() {
        return dState;
    }

    public void setdState(Integer dState) {
        this.dState = dState;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "dId=" + dId +
                ", dName='" + dName + '\'' +
                ", dIdcard='" + dIdcar + '\'' +
                ", dPhone='" + dPhone + '\'' +
                ", dTelphone='" + dTelphone + '\'' +
                ", dSex=" + dSex +
                ", dBirthday=" + dBirthday +
                ", dAge=" + dAge +
                ", dEmail='" + dEmail + '\'' +
                ", dKeshi='" + dKeshi + '\'' +
                ", dXueli='" + dXueli + '\'' +
                ", dDesc='" + dDesc + '\'' +
                ", dIntime=" + dIntime +
                ", dState=" + dState +
                '}';
    }

    public Doctor(Integer dId, String dName, String dKeshi) {
        this.dId = dId;
        this.dName = dName;
        this.dKeshi = dKeshi;
    }

    public Doctor() {
    }

    public Doctor(Integer dId, String dName, String dIdcar, String dPhone, String dTelphone, Integer dSex, Date dBirthday, Integer dAge, String dEmail, String dKeshi, String dXueli, String dDesc) {
        this.dId = dId;
        this.dName = dName;
        this.dIdcar = dIdcar;
        this.dPhone = dPhone;
        this.dTelphone = dTelphone;
        this.dSex = dSex;
        this.dBirthday = dBirthday;
        this.dAge = dAge;
        this.dEmail = dEmail;
        this.dKeshi = dKeshi;
        this.dXueli = dXueli;
        this.dDesc = dDesc;
    }

    public Doctor(String dName, String dIdcar, String dPhone, String dTelphone, Integer dSex, Date dBirthday, Integer dAge, String dEmail, String dKeshi, String dXueli, String dDesc) {
        this.dName = dName;
        this.dIdcar = dIdcar;
        this.dPhone = dPhone;
        this.dTelphone = dTelphone;
        this.dSex = dSex;
        this.dBirthday = dBirthday;
        this.dAge = dAge;
        this.dEmail = dEmail;
        this.dKeshi = dKeshi;
        this.dXueli = dXueli;
        this.dDesc = dDesc;
    }
}