package cn.com.csii.service.impl;

import cn.com.csii.dao.ProductDao;
import cn.com.csii.domain.Order;
import cn.com.csii.domain.Product;
import cn.com.csii.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> findAll() throws Exception{
        System.out.println("service执行了******************************************");
        return productDao.findAll();
    }



    @Override
    public void save(Product product) {
        productDao.save(product);
    }


}
