/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cv.inv.api.dao;

import com.cv.inv.api.entity.SaleHisDetail;

import java.util.List;

/**
 * @author Mg Kyaw Thura Aung
 */
 public interface SaleHisDetailDao {

    SaleHisDetail save(SaleHisDetail sdh);

    List<SaleHisDetail> search(String vouNo);

    int delete(String id);
}