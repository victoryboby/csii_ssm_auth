package cn.com.csii.dao;

import cn.com.csii.domain.Role;
import cn.com.csii.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    @Select("select * from users where username=#{username}")
    @Results(
            {       @Result(id = true, property = "id", column = "id"),
                    @Result(property = "username", column = "username"),
                    @Result(property = "email", column = "email"),
                    @Result(property = "password", column = "password"),
                    @Result(property = "phoneNum", column = "phoneNum"),
                    @Result(property = "status", column = "status"),
                    @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "cn.com.csii.dao.RoleDao.findRoleById"))
            }
    )
    public UserInfo findUserByName(String username) throws Exception;

    @Select("select * from users")
    public List<UserInfo> findAll() throws Exception;

    @Insert("insert into users(username,password,email,phonenum,status) VALUES (#{username},#{password},#{email},#{phoneNum},#{status})")
    public void saveUser(UserInfo userInfo);

    @Select("select * from users where id=#{id}")
    @Results(
            {       @Result(id = true, property = "id", column = "id"),
                    @Result(property = "username", column = "username"),
                    @Result(property = "email", column = "email"),
                    @Result(property = "password", column = "password"),
                    @Result(property = "phoneNum", column = "phoneNum"),
                    @Result(property = "status", column = "status"),
                    @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "cn.com.csii.dao.RoleDao.findRolePreById"))
            }
    )
    public UserInfo findById(String id) throws Exception;


    @Insert("insert into users_role(userid,roleid) values (#{userId},#{roleId})")
    void addRoleToUser(@Param("userId")String userId,@Param("roleId")String id) throws Exception;
}
