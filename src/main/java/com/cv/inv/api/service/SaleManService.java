/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cv.inv.api.service;

import com.cv.inv.api.entity.SaleMan;
import java.util.List;

/**
 *
 * @author Mg Kyaw Thura Aung
 */
public interface SaleManService {

    public SaleMan save(SaleMan saleMan) throws Exception;

    public List<SaleMan> findAll(String compCode);

    public int delete(String id);

    public SaleMan findByCode(String code);
}
