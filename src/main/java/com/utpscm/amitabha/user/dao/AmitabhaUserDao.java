package com.utpscm.amitabha.user.dao;

import com.utpscm.amitabha.user.model.AmitabhaUser;

public interface AmitabhaUserDao {

	public AmitabhaUser queryUserByAccount(String account);
	
	public AmitabhaUser queryUserById(Integer id);
	
}
