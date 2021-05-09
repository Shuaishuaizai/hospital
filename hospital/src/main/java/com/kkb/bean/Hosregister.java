package com.kkb.bean;

import javax.persistence.Id;

/**
 * @author xiaoyou
 *
 */
public class Hosregister {
    @Id
    private Integer hosrId;

    private String hosrIdcar;

    private String hosrMedical;

    private Double hosrRegprice;

    private String hosrPhone;

    private Integer hosrSelfprice;

    private Integer hosrSex;

    private Integer hosrAge;

    private String hosrWork;

    private String hosrLookdoctor;

    private Integer dId;

    private String hosrRemark;

    private Integer hosrState;

    public Integer getHosrId() {
        return hosrId;
    }

    public void setHosrId(Integer hosrId) {
        this.hosrId = hosrId;
    }

    public String getHosrIdcar() {
        return hosrIdcar;
    }

    public void setHosrIdcar(String hosrIdcar) {
        this.hosrIdcar = hosrIdcar == null ? null : hosrIdcar.trim();
    }

    public String getHosrMedical() {
        return hosrMedical;
    }

    public void setHosrMedical(String hosrMedical) {
        this.hosrMedical = hosrMedical == null ? null : hosrMedical.trim();
    }

    public Double getHosrRegprice() {
        return hosrRegprice;
    }

    public void setHosrRegprice(Double hosrRegprice) {
        this.hosrRegprice = hosrRegprice;
    }

    public String getHosrPhone() {
        return hosrPhone;
    }

    public void setHosrPhone(String hosrPhone) {
        this.hosrPhone = hosrPhone == null ? null : hosrPhone.trim();
    }

    public Integer getHosrSelfprice() {
        return hosrSelfprice;
    }

    public void setHosrSelfprice(Integer hosrSelfprice) {
        this.hosrSelfprice = hosrSelfprice;
    }

    public Integer getHosrSex() {
        return hosrSex;
    }

    public void setHosrSex(Integer hosrSex) {
        this.hosrSex = hosrSex;
    }

    public Integer getHosrAge() {
        return hosrAge;
    }

    public void setHosrAge(Integer hosrAge) {
        this.hosrAge = hosrAge;
    }

    public String getHosrWork() {
        return hosrWork;
    }

    public void setHosrWork(String hosrWork) {
        this.hosrWork = hosrWork == null ? null : hosrWork.trim();
    }

    public String getHosrLookdoctor() {
        return hosrLookdoctor;
    }

    public void setHosrLookdoctor(String hosrLookdoctor) {
        this.hosrLookdoctor = hosrLookdoctor == null ? null : hosrLookdoctor.trim();
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getHosrRemark() {
        return hosrRemark;
    }

    public void setHosrRemark(String hosrRemark) {
        this.hosrRemark = hosrRemark == null ? null : hosrRemark.trim();
    }

    public Integer getHosrState() {
        return hosrState;
    }

    public void setHosrState(Integer hosrState) {
        this.hosrState = hosrState;
    }
}