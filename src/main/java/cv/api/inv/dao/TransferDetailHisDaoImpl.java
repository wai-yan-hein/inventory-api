/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.api.inv.dao;

import cv.api.inv.entity.TransferDetailHis;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wai yan
 */
@Repository
public class TransferDetailHisDaoImpl extends AbstractDao<Long, TransferDetailHis> implements TransferDetailHisDao {

    @Override
    public TransferDetailHis save(TransferDetailHis sdh) {
        persist(sdh);
        return sdh;
    }

    @Override
    public TransferDetailHis findById(Long id) {
        return getByKey(id);
    }

    @Override
    public List<TransferDetailHis> search(String saleInvId) {
        String strFilter = "";
          if (!saleInvId.equals("-")) {
              strFilter = "v.tranVouId = '" + saleInvId + "'";
        }
            String strSql = "select v from TransferDetailHis v";

        List<TransferDetailHis> listDH = null;
        if (!strFilter.isEmpty()) {
            strSql = strSql + " where " + strFilter;
            listDH = findHSQL(strSql);
        }

        return listDH;
    }

    @Override
    public int delete(String id) {
        String strSql = "delete from TransferDetailHis o where o.tranDetailId = " + id;
        return execUpdateOrDelete(strSql);
    }

}
