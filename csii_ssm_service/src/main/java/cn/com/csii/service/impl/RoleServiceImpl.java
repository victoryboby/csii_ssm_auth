package cn.com.csii.service.impl;

import cn.com.csii.dao.RoleDao;
import cn.com.csii.domain.Permission;
import cn.com.csii.domain.Role;
import cn.com.csii.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    @Override
    public void saveRole(Role role) throws Exception {
        roleDao.saveRole(role);
    }

    @Override
    public List<Role> findUserByIdAndAllRole(String id) throws Exception {
        return roleDao.findUserByIdAndAllRole(id);
    }

    @Override
    public Role findById(String id) throws Exception {
        return roleDao.findById(id);
    }

    @Override
    public void addPreToRole(String roleId, String id) throws Exception {
        roleDao.addPerToRole(roleId,id);
    }


}
