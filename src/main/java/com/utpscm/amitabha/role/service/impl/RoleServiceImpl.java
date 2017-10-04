package com.utpscm.amitabha.role.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.utpscm.amitabha.role.dao.RoleDao;
import com.utpscm.amitabha.role.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService{
	
	@Resource
	private RoleDao roleDao;

	@Override
	public Set<String> queryRolesByUserId(Integer id) {
		return roleDao.queryRolesByUserId(id);
	}

	@Override
	public Set<String> queryRolesByUsername(String username) {
		return roleDao.queryRolesByUsername(username);
	}

}
