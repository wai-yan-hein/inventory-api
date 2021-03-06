/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.api.inv.dao;

import cv.api.inv.entity.RetOutHis;
import cv.api.inv.view.VReturnOut;

import java.util.List;

/**
 * @author wai yan
 */
public interface RetOutDao {

    RetOutHis save(RetOutHis saleHis);

    List<RetOutHis> search(String fromDate, String toDate, String cusCode,
                           String vouNo, String remark, String userCode);

    RetOutHis findById(String id);

    int delete(String vouNo) throws Exception;

    List<VReturnOut> search(String vouNo);
}
