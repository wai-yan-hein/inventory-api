/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cv.inv.api.dao;

import com.cv.inv.api.entity.RelationKey;
import com.cv.inv.api.entity.UnitRelation;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface RelationDao {

    public UnitRelation save(UnitRelation relation);

    public UnitRelation findByKey(RelationKey key);

    public List<UnitRelation> findAll();

    public List<UnitRelation> search(String patternId);

}
