package com.utpscm.amitabha.user.dao.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.utpscm.amitabha.user.dao.AmitabhaUserDao;
import com.utpscm.amitabha.user.model.AmitabhaUser;

@Service("amitabhaUserDao")
public class AmitabhaUserDaoImpl implements AmitabhaUserDao {

	private static final String NAME_SPACE = "com.utpscm.amitabha.security.dao.AmitabhaUserDao.";
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public AmitabhaUser queryUserByAccount(String account) {
		if(StringUtils.isEmpty(account)){
			return null;
		} else {
			return sqlSessionTemplate.selectOne(NAME_SPACE + "queryUserByAccount", account);
		}
	}

	@Override
	public AmitabhaUser queryUserById(Integer id) {
		if(id == null) {
			return null;
		} else {
			return sqlSessionTemplate.selectOne(NAME_SPACE + "queryUserById", id);
		}
	}

}
