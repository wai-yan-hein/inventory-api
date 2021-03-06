/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.api.inv.service;

import cv.api.common.Util1;
import cv.api.inv.dao.SaleManDao;
import cv.api.inv.entity.SaleMan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wai yan
 */
@Service
@Transactional
public class SaleManServiceImpl implements SaleManService {

    @Autowired
    private SaleManDao dao;
    @Autowired
    private SeqTableService seqService;

    @Override
    public SaleMan save(SaleMan sm) throws Exception {
        if (Util1.isNull(sm.getSaleManCode())) {
            Integer macId = sm.getMacId();
            String compCode = sm.getCompCode();
            String code = getSaleManCode(macId, "SM", "-", compCode);
            SaleMan valid = findByCode(code);
            if (valid == null) {
                sm.setSaleManCode(code);
            } else {
                throw new IllegalStateException("Duplicate Sale Man Code");
            }
        }
        return dao.save(sm);
    }

    @Override
    public int delete(String id) {
        return dao.delete(id);
    }

    @Override
    public SaleMan findByCode(String code) {
        return dao.findByCode(code);
    }

    private String getSaleManCode(Integer macId, String option, String period, String compCode) {
        int seqNo = seqService.getSequence(macId, option, period, compCode);
        return String.format("%0" + 2 + "d", macId) + "-" + String.format("%0" + 3 + "d", seqNo);
    }

    @Override
    public List<SaleMan> findAll(String compCode) {
        return dao.findAll(compCode);
    }
}
