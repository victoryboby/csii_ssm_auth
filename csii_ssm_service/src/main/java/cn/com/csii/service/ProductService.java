package cn.com.csii.service;



import cn.com.csii.domain.Order;
import cn.com.csii.domain.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll() throws Exception;

    public void save(Product product);
}
