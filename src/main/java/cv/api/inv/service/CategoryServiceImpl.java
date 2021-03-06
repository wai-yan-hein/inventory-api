/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.api.inv.service;

import cv.api.common.Util1;
import cv.api.inv.dao.CategoryDao;
import cv.api.inv.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wai yan
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao dao;

    @Autowired
    private SeqTableService seqService;

    @Override
    public Category save(Category cat) throws Exception {
        if (Util1.isNull(cat.getCatCode())) {
            Integer macId = cat.getMacId();
            String compCode = cat.getCompCode();
            String catCode = getCatCode(macId, compCode);
            Category valid = findByCode(catCode);
            if (valid == null) {
                cat.setCatCode(catCode);
            } else {
                throw new IllegalStateException("Duplicate Category Code");
            }
        }
        return dao.save(cat);
    }

    @Override
    public List<Category> findAll(String compCode) {
        return dao.findAll(compCode);
    }

    @Override
    public int delete(String id) {
        return dao.delete(id);
    }

    @Override
    public List<Category> search(String catName) {
        return dao.search(catName);
    }

    @Override
    public List<Category> searchM(String updatedDate) {
        return dao.searchM(updatedDate);
    }

    private String getCatCode(Integer macId, String compCode) {
        int seqNo = seqService.getSequence(macId, "Category", "-", compCode);
        return String.format("%0" + 3 + "d", macId) + "-" + String.format("%0" + 4 + "d", seqNo);
    }

    @Override
    public Category findByCode(String code) {
        return dao.findByCode(code);
    }

}
