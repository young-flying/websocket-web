package org.jewi.study.service.impl;

import java.util.List;

import org.jewi.study.dao.UserMapper;
import org.jewi.study.entity.User;
import org.jewi.study.entity.UserExample;
import org.jewi.study.service.UserService;
import org.jewi.study.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int add(User user) {
		return userMapper.insert(user);
	}

	@Override
	public int update(User user) {
		return userMapper.updateByPrimaryKey(user);
	}

	@Override
	public int deleteById(long userId) {
		return userMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public User queryUserById(Long userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public List<User> queryList(int pageNum,int pageSize) {
		UserExample example = new UserExample();
		PageHelper.startPage(pageNum, pageSize);
		
		return userMapper.selectByExample(example);
	}

	@Override
	public boolean login(String username, String password) {
		if(StringUtil.isBlank(username) || null == password) {
			return false;
		}
		
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(username)
		.andPasswordEqualTo(password);
		
		List<User> userList = userMapper.selectByExample(example);
		
		if(null != userList && userList.size() == 1) {
			return true;
		}
		
		return false;
	}

}
