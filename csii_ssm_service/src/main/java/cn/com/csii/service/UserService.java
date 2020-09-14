package cn.com.csii.service;

import cn.com.csii.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    public List<UserInfo> findAll() throws Exception;

    public  void saveUser(UserInfo userInfo) throws Exception;

    public  UserInfo findById(String id) throws  Exception;


    void addRoleToUser(String userId, String id) throws Exception;
}
