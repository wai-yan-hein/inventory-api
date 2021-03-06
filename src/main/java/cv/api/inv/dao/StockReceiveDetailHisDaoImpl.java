/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.api.inv.dao;

import cv.api.inv.entity.StockReceiveDetailHis;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wai yan
 */
@Repository
public class StockReceiveDetailHisDaoImpl extends AbstractDao<Long, StockReceiveDetailHis> implements StockReceiveDetailHisDao {

    @Override
    public StockReceiveDetailHis save(StockReceiveDetailHis sdh) {
        persist(sdh);
        return sdh;
    }

    @Override
    public StockReceiveDetailHis findById(Long id) {
        return getByKey(id);
    }

    @Override
    public List<StockReceiveDetailHis> search(String saleInvId) {
        String strFilter = "";
          if (!saleInvId.equals("-")) {
              strFilter = "v.refVou = '" + saleInvId+"'";
          }
            String strSql = "select v from StockReceiveDetailHis v";

        List<StockReceiveDetailHis> listDH = null;
        if (!strFilter.isEmpty()) {
            strSql = strSql + " where " + strFilter;
            listDH = findHSQL(strSql);
        }

        return listDH;
    }

    @Override
    public int delete(String id) {
        String strSql = "delete from StockReceiveDetailHis o where o.tranId = " + id;
        return execUpdateOrDelete(strSql);
    }

}
