package cn.com.csii.dao;

import cn.com.csii.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PermissionDao {
    @Select("select * from PERMISSION where id in (select PERMISSIONID from ROLE_PERMISSION where RoleID = #{id})")
    public List<Permission> findPerByRoleId(String id);

    @Select("select * from PERMISSION")
    List<Permission> findAll() throws Exception;

    @Insert("insert into PERMISSION(PERMISSIONNAME,URL) VALUES(#{permissionName},#{url})")
    void savePer(Permission permission);

    @Select("SELECT * from Permission WHERE id not in (SELECT permissionId from ROLE_PERMISSION where roleid = #{id})")
    List<Permission> findPerByIdAndAllPre(String id) throws Exception;
}
