package cn.com.csii.dao;

import cn.com.csii.domain.UserInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    @Select("select * from users where username=#{username}")
    public UserInfo findUserByName(String username) throws Exception;
}
