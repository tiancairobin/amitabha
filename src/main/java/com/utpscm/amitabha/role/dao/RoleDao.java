package com.utpscm.amitabha.role.dao;

import java.util.Set;

public interface RoleDao {

	public Set<String> queryRolesByUserId(Integer id);

	public Set<String> queryRolesByUsername(String username);
	
}
