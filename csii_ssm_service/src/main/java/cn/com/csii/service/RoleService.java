package cn.com.csii.service;

import cn.com.csii.domain.Permission;
import cn.com.csii.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RoleService {
   public List<Role> findAll() throws Exception;

    void saveRole(Role role) throws Exception;

    List<Role> findUserByIdAndAllRole(String id) throws Exception;

    Role findById(String id) throws Exception;


    void addPreToRole(String roleId, String id) throws Exception;
}
