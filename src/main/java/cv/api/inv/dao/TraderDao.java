/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.api.inv.dao;

import cv.api.inv.entity.Trader;

import java.util.List;

/**
 *
 * @author WSwe
 */
 public interface TraderDao {

     Trader findByCode(String id);

     List<Trader> searchTrader(String code, String name, String address,
            String phone, String parentCode, String compCode, String appTraderCode);

     Trader saveTrader(Trader trader);

     List<Trader> search(String regionCode, String coaCode);

     List<Trader> findAll(String compCode);

     int delete(String code);

     List<Trader> findCustomer(String compCode);

     List<Trader> findSupplier(String compCode);

}
