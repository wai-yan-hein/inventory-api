/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.api.inv.dao;

import cv.api.inv.entity.Location;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wai yan
 */
@Repository
public class LocationDaoImpl extends AbstractDao<String, Location> implements LocationDao {


    @Override
    public Location save(Location ch) {
        persist(ch);
        return ch;
    }

    @Override
    public List<Location> findAll(String compCode) {
        String hsql = "select o from Location o where o.compCode ='" + compCode + "'";
        return findHSQL(hsql);
    }

    @Override
    public int delete(String id) {
        String hsql = "delete from Location o where o.locationCode='" + id + "'";
        return execUpdateOrDelete(hsql);
    }

    @Override
    public List<Location> search(String parent) {
        String hsql = "select o from Location o where o.parentCode ='" + parent + "'";
        return findHSQL(hsql);

    }

    @Override
    public Location findByCode(String code) {
        return getByKey(code);
    }

}
