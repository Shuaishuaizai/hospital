package com.kkb.bean;


import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;
/**
 * @author xiaoyou
 *
 */
@Table(name = "user")
public class User {
    private Integer uLoginName;

    private String uPassword;

    private String uTrueName;

    private String uEmail;

    private Integer uState;

    private Integer rId;

    private Integer uId;

    @Transient
    private Role role;


    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public void setuTrueName(String uTrueName) {
        this.uTrueName = uTrueName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getuLoginName() {
        return uLoginName;
    }

    public void setuLoginName(Integer uLoginname) {
        this.uLoginName = uLoginname;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword == null ? null : uPassword.trim();
    }

    public String getuTrueName() {
        return uTrueName;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail == null ? null : uEmail.trim();
    }

    public Integer getuState() {
        return uState;
    }

    public void setuState(Integer uState) {
        this.uState = uState;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    @Override
    public String toString() {
        return "User{" +
                "uLoginname=" + uLoginName +
                ", uPassword='" + uPassword + '\'' +
                ", uTruename='" + uTrueName + '\'' +
                ", uEmail='" + uEmail + '\'' +
                ", uState=" + uState +
                ", rId=" + rId +
                '}';
    }
}