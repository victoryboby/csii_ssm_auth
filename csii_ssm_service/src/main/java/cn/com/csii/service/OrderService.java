package cn.com.csii.service;

import cn.com.csii.domain.Order;

import java.util.List;

public interface OrderService {
    public List<Order> findAll(Integer pageNum,Integer pageSize) throws Exception;

    public Order findById(String id) throws Exception;
}
