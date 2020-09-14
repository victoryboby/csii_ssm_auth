package cn.com.csii.dao;

import cn.com.csii.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface RoleDao {



    @Select("select * from ROLE where id in (SELECT ROLEID from USERS_ROLE where userid = #{id} )")
    public List<Role> findRoleById(String id);

    @Select("select * from ROLE where id in (SELECT ROLEID from USERS_ROLE where userid = #{id} )")
    @Results(
            {
                    @Result(id = true,property = "id",column = "id"),
                    @Result(property = "roleName",column = "rolename"),
                    @Result(property = "roleDesc",column = "roleDesc"),
                    @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select =
                            "cn.com.csii.dao.PermissionDao.findPerByRoleId")),
            }
    )
    public List<Role> findRolePreById(String id);


    @Select("select * from role")
    List<Role> findAll() throws Exception;

    @Insert("insert into role(rolename,roledesc) values (#{roleName},#{roleDesc})")
    void saveRole(Role role) throws Exception;

    @Select("SELECT * from Role WHERE id not in (SELECT ROLEID from USERS_ROLE where USERID = #{id})")
    List<Role> findUserByIdAndAllRole(String id) throws Exception;

    @Select("select * from Role where id = #{id}")
    Role findById(String id);

    @Insert("insert into role_permission(permissionid,roleid) values (#{pid},#{rid})")
    void addPerToRole(@Param("rid") String roleId, @Param("pid") String id);
}
