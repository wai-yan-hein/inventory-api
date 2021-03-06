/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.api.inv.service;

import cv.api.inv.dao.RetInDetailDao;
import cv.api.inv.entity.RetInHisDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wai yan
 */
@Service
@Transactional
public class RetInDetailServiceImpl implements RetInDetailService {

    private static final Logger log = LoggerFactory.getLogger(RetInServiceImpl.class);

    @Autowired
    private RetInDetailDao dao;

    @Override
    public RetInHisDetail save(RetInHisDetail pd) {

        return dao.save(pd);
    }

    @Override
    public List<RetInHisDetail> search(String glCode) {
        return dao.search(glCode);
    }

    @Override
    public int delete(String id) throws Exception {
        return dao.delete(id);
    }

}
