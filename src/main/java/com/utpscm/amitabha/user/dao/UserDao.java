package com.utpscm.amitabha.user.dao;

import com.utpscm.amitabha.user.model.User;

public interface UserDao {

	public User queryUserByUsername(String account);
	
	public User queryUserById(Integer id);
	
	public User login(String account, String password);
	
}
