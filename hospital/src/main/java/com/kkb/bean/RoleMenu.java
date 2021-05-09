package com.kkb.bean;
/**
 * @author xiaoyou
 *
 */
public class RoleMenu {
    private Integer rId;

    private Integer mId;

    public RoleMenu() {
    }

    public RoleMenu(Integer rId, Integer mId) {
        this.rId = rId;
        this.mId = mId;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }
}