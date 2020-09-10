package cn.com.csii.dao;

import cn.com.csii.domain.Member;
import cn.com.csii.domain.Order;
import cn.com.csii.domain.Product;
import cn.com.csii.domain.Traveller;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderDao {


    @Select("select * from orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payTypeStr",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productid", one = @One(select = "cn.com.csii.dao.ProductDao.findById"))

    })
    public List<Order> findAll();

    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productid",javaType =Product.class, one = @One(select = "cn.com.csii.dao.ProductDao.findById")),
            @Result(property = "member",column = "memberid",javaType =Member.class, one = @One(select = "cn.com.csii.dao.MemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType =java.util.List.class, many = @Many(select = "cn.com.csii.dao.TravellerDao.findById"))

    })
    public Order findById(String id);
}
