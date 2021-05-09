package com.kkb.bean;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
/**
 * @author xiaoyou
 *
 */
@Table(name = "drug")
public class Drug {
    @Id
    private Integer drId;

    private String drUrl;

    private Double drInprice;

    private Double drOutprice;


    private String drName;

    private String drType;

    private String drSimdesc;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date drDate;

    private String drDetadesc;

    private String drFatory;

    private String drDirection;

    private String drRemark;

    private Integer drNumber;

    public Integer getDrId() {
        return drId;
    }

    public void setDrId(Integer drId) {
        this.drId = drId;
    }

    public String getDrUrl() {
        return drUrl;
    }

    public void setDrUrl(String drUrl) {
        this.drUrl = drUrl == null ? null : drUrl.trim();
    }

    public Double getDrInprice() {
        return drInprice;
    }

    public void setDrInprice(Double drInprice) {
        this.drInprice = drInprice;
    }

    public Double getDrOutprice() {
        return drOutprice;
    }

    public void setDrOutprice(Double drOutprice) {
        this.drOutprice = drOutprice;
    }

    public String getDrName() {
        return drName;
    }

    public void setDrName(String drName) {
        this.drName = drName == null ? null : drName.trim();
    }

    public String getDrType() {
        return drType;
    }

    public void setDrType(String drType) {
        this.drType = drType == null ? null : drType.trim();
    }

    public String getDrSimdesc() {
        return drSimdesc;
    }

    public void setDrSimdesc(String drSimdesc) {
        this.drSimdesc = drSimdesc == null ? null : drSimdesc.trim();
    }

    public Date getDrDate() {
        return drDate;
    }

    public void setDrDate(Date drDate) {
        this.drDate = drDate;
    }

    public String getDrDetadesc() {
        return drDetadesc;
    }

    public void setDrDetadesc(String drDetadesc) {
        this.drDetadesc = drDetadesc == null ? null : drDetadesc.trim();
    }

    public String getDrFatory() {
        return drFatory;
    }

    public void setDrFatory(String drFatory) {
        this.drFatory = drFatory == null ? null : drFatory.trim();
    }

    public String getDrDirection() {
        return drDirection;
    }

    public void setDrDirection(String drDirection) {
        this.drDirection = drDirection == null ? null : drDirection.trim();
    }

    public String getDrRemark() {
        return drRemark;
    }

    public void setDrRemark(String drRemark) {
        this.drRemark = drRemark == null ? null : drRemark.trim();
    }

    public Integer getDrNumber() {
        return drNumber;
    }

    public void setDrNumber(Integer drNumber) {
        this.drNumber = drNumber;
    }
}