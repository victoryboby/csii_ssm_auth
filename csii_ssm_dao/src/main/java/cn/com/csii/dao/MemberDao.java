package cn.com.csii.dao;

import cn.com.csii.domain.Member;
import cn.com.csii.domain.Order;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MemberDao {
    @Select("select * from member where id=#{id}")
    public Member findById(String id);
}
