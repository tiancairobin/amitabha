package com.utpscm.amitabha.user.dao.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.utpscm.amitabha.user.dao.UserDao;
import com.utpscm.amitabha.user.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	private static final String NAME_SPACE = "com.utpscm.amitabha.user.dao.UserDao.";
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public User queryUserByUsername(String username) {
		if(StringUtils.isEmpty(username)){
			return null;
		} else {
			return sqlSessionTemplate.selectOne(NAME_SPACE + "queryUserByAccount", username);
		}
	}

	@Override
	public User queryUserById(Integer id) {
		if(id == null) {
			return null;
		} else {
			return sqlSessionTemplate.selectOne(NAME_SPACE + "queryUserById", id);
		}
	}

	@Override
	public User login(String username, String password) {
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			return null;
		} else {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("username", username);
			params.put("password", password);
			return sqlSessionTemplate.selectOne(NAME_SPACE + "login", params);
		}
	}

}
