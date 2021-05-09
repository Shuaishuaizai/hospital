package com.kkb.bean;

public class BootStrapTableMenu {
    private Integer mId;

    private String mName;

    private String mState;

    private String mUrl;

    public BootStrapTableMenu(Integer mId, String mName, String mState, String mUrl) {
        this.mId = mId;
        this.mName = mName;
        this.mState = mState;
        this.mUrl = mUrl;
    }

    @Override
    public String toString() {
        return "BootStrapTableMenu{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mState='" + mState + '\'' +
                ", mUrl='" + mUrl + '\'' +
                '}';
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
        this.mName = mName;
    }

    public String getmState() {
        return mState;
    }

    public void setmState(String mState) {
        this.mState = mState;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}
