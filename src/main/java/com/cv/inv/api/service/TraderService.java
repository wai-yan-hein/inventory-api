/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cv.inv.api.service;

import com.cv.inv.api.entity.Trader;
import java.util.List;

/**
 *
 * @author WSwe
 */
public interface TraderService {

    public Trader findByCode(String code);

    public List<Trader> searchTrader(String code, String name, String address,
            String phone, String parentCode, String compCode,
            String appTraderCode);

    public List<Trader> search(String regionCode, String coaCode);

    public List<Trader> searchM(String updatedDate);

    public Trader saveTrader(Trader trader) throws Exception;

    public List<Trader> findAll(String compCode);

    public List<Trader> findCustomer(String compCode);

    public List<Trader> findSupplier(String compCode);

    public int delete(String code);
}