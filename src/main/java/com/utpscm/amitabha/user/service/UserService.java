package com.utpscm.amitabha.user.service;

import com.utpscm.amitabha.user.model.User;

public interface UserService {

	public User queryUserByUsername(String account);
	
	public User login(String account, String password);
}
