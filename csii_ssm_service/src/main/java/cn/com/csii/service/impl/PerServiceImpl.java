package cn.com.csii.service.impl;

import cn.com.csii.dao.PermissionDao;
import cn.com.csii.domain.Permission;
import cn.com.csii.service.PerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerServiceImpl implements PerService {
    @Autowired
    private PermissionDao permissionDao;
    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public void savaPer(Permission permission) throws Exception {
        permissionDao.savePer(permission);
    }

    @Override
    public List<Permission> findPerByIdAndAllPre(String id) throws Exception {
        return permissionDao.findPerByIdAndAllPre(id);
    }
}
