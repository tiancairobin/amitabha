package com.utpscm.amitabha.menu.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.utpscm.amitabha.menu.dao.MenuDao;

@Repository("menuDao")
public class MenuDaoImpl implements MenuDao {
	
	private static final String NAME_SPACE = "com.utpscm.amitabha.menu.dao.MenuDao.";
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public Set<String> queryMenusByUsername(String username) {
		if (!StringUtils.isEmpty(username)) {
			List<String> menuList = sqlSessionTemplate.selectList(NAME_SPACE + "queryMenusByUsername", username);
			Set<String> menuSet = new HashSet<String>(menuList);
			return menuSet;
		} else {
			return null;
		}
	}

}
