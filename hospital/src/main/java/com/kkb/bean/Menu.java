package com.kkb.bean;

import javax.persistence.Id;

/**
 * @author xiaoyou
 *
 */
public class Menu {
    @Id
    private Integer mId;

    private String mName;

    private Integer mState;

    private String mUrl;

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName == null ? null : mName.trim();
    }

    public Integer getmState() {
        return mState;
    }

    public void setmState(Integer mState) {
        this.mState = mState;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mState=" + mState +
                ", mUrl='" + mUrl + '\'' +
                '}';
    }
}