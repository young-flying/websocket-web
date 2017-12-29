package org.jewi.study.service;

import java.util.Map;

import org.jewi.study.entity.User;
import org.jewi.study.utils.Page;

public interface UserService {
	int add(User user);
    int update(User user);
    int deleteById(long userId);
    User queryUserById(Long user);
    Page queryUserList(Map<String,Object> params);
    
    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    boolean login(String username,String password);
}
