/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.api.inv.service;

import cv.api.inv.dao.OrderDao;
import cv.api.inv.dao.OrderDetailDao;
import cv.api.inv.entity.Order;
import cv.api.inv.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wai yan
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao dao;
    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    public Order save(Order order, List<OrderDetail> listOD) {
        int uniqueId = 1;
        for (OrderDetail od : listOD) {
            if (od.getStock().getStockCode() != null) {
                od.setUniqueId(uniqueId);
                od.setId(order.getOrderCode() + "-" + uniqueId);
                od.setOrderCode(order.getOrderCode());
                orderDetailDao.save(od);
                uniqueId++;
            }
        }
        return dao.save(order);
    }

    @Override
    public int delete(String id) {
        return dao.delete(id);
    }

    @Override
    public List<Order> findActiveOrder(String fromDate, String toDate, String cusId, String orderCode) {
        return dao.findActiveOrder(fromDate, toDate, cusId, orderCode);
    }

}
