package cn.com.csii.service.impl;

import cn.com.csii.dao.OrderDao;
import cn.com.csii.domain.Order;
import cn.com.csii.service.OrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public List<Order> findAll(Integer pageNum,Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        return orderDao.findAll();
    }

    @Override
    public Order findById(String id) throws Exception {
        return orderDao.findById(id);
    }
}
