/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.api.inv.service;

import cv.api.common.Util1;
import cv.api.inv.dao.SaleHisDao;
import cv.api.inv.dao.SaleHisDetailDao;
import cv.api.inv.dao.SeqTableDao;
import cv.api.inv.entity.SaleDetailKey;
import cv.api.inv.entity.SaleHis;
import cv.api.inv.entity.SaleHisDetail;
import cv.api.inv.view.VSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wai yan
 */
@Service
@Transactional
public class SaleHisServiceImpl implements SaleHisService {

    @Autowired
    private SaleHisDao shDao;
    @Autowired
    private SaleHisDetailDao sdDao;
    @Autowired
    private SeqTableDao seqDao;

    public SaleHisServiceImpl() {
    }

    @Override
    public SaleHis save(SaleHis saleHis) throws Exception {
        String status = saleHis.getStatus();
        if (Util1.isNullOrEmpty(saleHis.getVouNo())) {
            saleHis.setVouNo(getVoucherNo(saleHis.getMacId(), saleHis.getCompCode()));
        }
        if (saleHis.isDeleted()) {
            shDao.save(saleHis);
        } else {
            List<SaleHisDetail> listSD = saleHis.getListSH();
            List<String> listDel = saleHis.getListDel();
            String vouNo = saleHis.getVouNo();
            if (status.equals("NEW")) {
                SaleHis valid = shDao.findById(vouNo);
                if (valid != null) {
                    throw new IllegalStateException("Duplicate Sale Voucher");
                }
            }
            if (listDel != null) {
                listDel.forEach(code -> {
                    if (code != null) {
                        sdDao.delete(code);
                    }
                });
            }
            for (int i = 0; i < listSD.size(); i++) {
                SaleHisDetail cSd = listSD.get(i);
                if (cSd.getStock() != null) {
                    if (cSd.getUniqueId() == null) {
                        if (i == 0) {
                            cSd.setUniqueId(1);
                        } else {
                            SaleHisDetail pSd = listSD.get(i - 1);
                            cSd.setUniqueId(pSd.getUniqueId() + 1);
                        }
                    }
                    String sdCode = vouNo + "-" + cSd.getUniqueId();
                    cSd.setSdKey(new SaleDetailKey(vouNo, sdCode));
                    sdDao.save(cSd);
                }
            }
            shDao.save(saleHis);
            saleHis.setListSH(listSD);
        }
        return saleHis;
    }

    @Override
    public SaleHis update(SaleHis saleHis) {
        return shDao.save(saleHis);
    }

    @Override
    public List<SaleHis> search(String fromDate, String toDate, String cusCode,
                                String vouNo, String remark, String userCode) {
        return shDao.search(fromDate, toDate, cusCode, vouNo, remark, userCode);
    }

    @Override
    public SaleHis findById(String id) {
        return shDao.findById(id);
    }

    @Override
    public int delete(String vouNo) throws Exception {
        return shDao.delete(vouNo);
    }

    private String getVoucherNo(Integer macId, String compCode) {
        String period = Util1.toDateStr(Util1.getTodayDate(), "MMyyyy");
        int seqNo = seqDao.getSequence(macId, "SALE", period, compCode);
        return String.format("%0" + 2 + "d", macId) + String.format("%0" + 5 + "d", seqNo) + "-" + period;
    }

    @Override
    public List<VSale> search(String vouNo) {
        return shDao.search(vouNo);
    }
}
