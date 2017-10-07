package com.utpscm.amitabha.menu.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.utpscm.amitabha.menu.dao.MenuDao;
import com.utpscm.amitabha.menu.service.MenuService;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
	
	@Resource
	private MenuDao menuDao;

	@Override
	public Set<String> queryMenusByUsername(String username) {
		return menuDao.queryMenusByUsername(username);
	}

}
