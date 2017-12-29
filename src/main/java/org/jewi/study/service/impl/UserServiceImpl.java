package org.jewi.study.service.impl;

import java.util.Map;

import org.jewi.study.dao.UserDao;
import org.jewi.study.entity.User;
import org.jewi.study.service.UserService;
import org.jewi.study.utils.Page;
import org.jewi.study.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public int add(User user) {
		return userDao.add(user);
	}

	@Override
	public int update(User user) {
		return userDao.update(user);
	}

	@Override
	public int deleteById(long userId) {
		return userDao.deleteById(userId);
	}

	@Override
	public User queryUserById(Long userId) {
		return userDao.queryById(userId);
	}

	@Override
	public Page queryUserList(Map<String, Object> params) {
		return userDao.queryList(params);
	}

	@Override
	public boolean login(String username, String password) {
		if(StringUtil.isBlank(username) || null == password) {
			return false;
		}
		
		User user = userDao.queryByUserName(username);
		
		if(null == user || user.getId() < 1 || !password.equals(user.getPassword())) {
			return false;
		}
		
		return true;
	}

}
