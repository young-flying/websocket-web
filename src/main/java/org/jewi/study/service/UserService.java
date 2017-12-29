package org.jewi.study.service;

import java.util.List;

import org.jewi.study.entity.User;

public interface UserService {
	int add(User user);
    int update(User user);
    int deleteById(long userId);
    User queryUserById(Long user);
    
    List<User> queryList(int pageNum,int pageSize);
    
    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    boolean login(String username,String password);
}
