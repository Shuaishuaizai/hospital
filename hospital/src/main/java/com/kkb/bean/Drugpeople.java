package com.kkb.bean;


import javax.persistence.Table;
/**
 * @author xiaoyou
 *
 */
@Table(name = "drugpeople")
public class Drugpeople {

    private Integer drId;

    private Integer peopleid;

    private Integer drNumber;

    public Integer getDrId() {
        return drId;
    }

    public void setDrId(Integer drId) {
        this.drId = drId;
    }

    public Integer getPeopleid() {
        return peopleid;
    }

    public void setPeopleid(Integer peopleid) {
        this.peopleid = peopleid;
    }

    public Integer getDrNumber() {
        return drNumber;
    }

    public void setDrNumber(Integer drNumber) {
        this.drNumber = drNumber;
    }
}