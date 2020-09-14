package cn.com.csii.service;

import cn.com.csii.domain.Permission;

import java.util.List;

public interface PerService {
    List<Permission> findAll() throws Exception;

    void savaPer(Permission permission) throws Exception;

    List<Permission> findPerByIdAndAllPre(String id) throws Exception;
}
