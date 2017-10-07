package com.utpscm.amitabha.menu.dao;

import java.util.Set;

public interface MenuDao {

	public Set<String> queryMenusByUsername(String username);
	
}
