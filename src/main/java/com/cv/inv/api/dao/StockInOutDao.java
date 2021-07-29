/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cv.inv.api.dao;

import com.cv.inv.api.entity.StockInOut;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface StockInOutDao {

    public StockInOut findById(String id);

    public StockInOut save(StockInOut stock);

    public List<StockInOut> search(String batchCode, String fromDate, String toDate, String desp, String remark);

    public int delete(String id);

}