/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cv.inv.api.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "stock_unit")
public class StockUnit implements java.io.Serializable {

    @Id
    @Column(name = "item_unit_code", unique = true, nullable = false, length = 10)
    private String itemUnitCode;
    @Column(name = "item_unit_name", nullable = false, length = 45, unique = true)
    private String itemUnitName;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    private Date updatedDate;
    @ManyToOne
    @JoinColumn(name = "updated_by")
    private AppUser updatedBy;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;
    @ManyToOne
    @JoinColumn(name = "created_by")
    private AppUser createdBy;
    @Column(name = "mac_id")
    private Integer macId;
    @Column(name = "user_code")
    private String userCode;
    @Column(name = "comp_code")
    private String compCode;
    

    public StockUnit(String itemUnitCode) {
        this.itemUnitCode = itemUnitCode;
    }
    
    public StockUnit() {
    }

    @Override
    public String toString() {
        return this.itemUnitCode;
    }

    public String getItemUnitCode() {
        return itemUnitCode;
    }

    public void setItemUnitCode(String itemUnitCode) {
        this.itemUnitCode = itemUnitCode;
    }

    public String getItemUnitName() {
        return itemUnitName;
    }

    public void setItemUnitName(String itemUnitName) {
        this.itemUnitName = itemUnitName;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public AppUser getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(AppUser updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public AppUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(AppUser createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getMacId() {
        return macId;
    }

    public void setMacId(Integer macId) {
        this.macId = macId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getCompCode() {
        return compCode;
    }

    public void setCompCode(String compCode) {
        this.compCode = compCode;
    }

    

}