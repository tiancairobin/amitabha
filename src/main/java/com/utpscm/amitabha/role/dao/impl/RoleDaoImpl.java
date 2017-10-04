package com.utpscm.amitabha.role.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.utpscm.amitabha.role.dao.RoleDao;

@Repository("roleDao")
public class RoleDaoImpl implements RoleDao {
	
private static final String NAME_SPACE = "com.utpscm.amitabha.role.dao.RoleDao.";
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public Set<String> queryRolesByUserId(Integer id) {
		if (id != null) {
			List<String> roleList = sqlSessionTemplate.selectList(NAME_SPACE + "queryRoleByUserId", id);
			Set<String> roleSet = new HashSet<String>(roleList);
			return roleSet;
		} else {
			return null;
		}
	}

	@Override
	public Set<String> queryRolesByUsername(String username) {
		if (!StringUtils.isEmpty(username)) {
			List<String> roleList = sqlSessionTemplate.selectList(NAME_SPACE + "queryRolesByUsername", username);
			Set<String> roleSet = new HashSet<String>(roleList);
			return roleSet;
		} else {
			return null;
		}
	}
}
