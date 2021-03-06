/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.api.inv.service;

import cv.api.inv.entity.Trader;

import java.util.List;

/**
 *
 * @author WSwe
 */
 public interface TraderService {

     Trader findByCode(String code);

     List<Trader> searchTrader(String code, String name, String address,
            String phone, String parentCode, String compCode,
            String appTraderCode);

     List<Trader> search(String regionCode, String coaCode);


     Trader saveTrader(Trader trader) throws Exception;

     List<Trader> findAll(String compCode);

     List<Trader> findCustomer(String compCode);

     List<Trader> findSupplier(String compCode);

     int delete(String code);
}
