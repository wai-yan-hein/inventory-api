/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cv.inv.api.dao;

import com.cv.inv.api.entity.StockType;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface StockTypeDao {

    public StockType save(StockType item);

    public List<StockType> findAll(String compCode);

    public int delete(String id);

    StockType findByCode(String code);
}