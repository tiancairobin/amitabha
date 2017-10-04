package com.utpscm.amitabha.role.service;

import java.util.Set;

public interface RoleService {
 
	public Set<String> queryRolesByUserId(Integer id);
	
	public Set<String> queryRolesByUsername(String username);
}
