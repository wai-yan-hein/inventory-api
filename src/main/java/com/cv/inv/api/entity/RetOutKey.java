/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cv.inv.api.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

/**
 *
 * @author lenovo
 */
@Data
@Embeddable
public class RetOutKey implements Serializable {

    @Column(name = "rd_code", unique = true, nullable = false)
    private String rdCode;
    @Column(name = "vou_no")
    private String vouNo;

    public RetOutKey() {
    }

    public RetOutKey(String rdCode, String vouNo) {
        this.rdCode = rdCode;
        this.vouNo = vouNo;
    }
}