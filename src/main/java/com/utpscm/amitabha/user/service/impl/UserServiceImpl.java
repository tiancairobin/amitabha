package com.utpscm.amitabha.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.utpscm.amitabha.user.dao.UserDao;
import com.utpscm.amitabha.user.model.User;
import com.utpscm.amitabha.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;

	@Override
	public User queryUserByUsername(String username) {
		return userDao.queryUserByUsername(username);
	}

	@Override
	public User login(String account, String password) {
		return userDao.login(account, password);
	}

}
