package cn.com.csii.dao;

import cn.com.csii.domain.Order;
import cn.com.csii.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TravellerDao {
    @Select("SELECT * from TRAVELLER WHERE ID IN (SELECT TRAVELLERID FROM ORDER_TRAVELLER WHERE ORDERID=#{id})")
    public List<Traveller> findById(String id);
}
