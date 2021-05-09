package com.kkb.bean;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;
/**
 * @author xiaoyou
 *
 */
public class Role {
    @Id
    private Integer rId;

    private String rName;

    private Integer rState;

    @Transient
    private  int[] mIds;



    public int[] getmIds() {
        return mIds;
    }

    public void setmIds(int[] mIds) {
        this.mIds = mIds;
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
        this.rName = rName == null ? null : rName.trim();
    }

    public Integer getrState() {
        return rState;
    }

    public void setrState(Integer rState) {
        this.rState = rState;
    }

}