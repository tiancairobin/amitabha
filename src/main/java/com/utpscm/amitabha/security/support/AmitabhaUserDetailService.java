package com.utpscm.amitabha.security.support;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.utpscm.amitabha.user.dao.AmitabhaUserDao;
import com.utpscm.amitabha.user.model.AmitabhaUser;

@Service
public class AmitabhaUserDetailService implements UserDetailsService{
	
	@Resource
	private AmitabhaUserDao amitabhaUserDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AmitabhaUser amitabhaUser = amitabhaUserDao.queryUserByAccount(username);
		if(amitabhaUser == null || amitabhaUser.getEnabled() != true) {
			throw new UsernameNotFoundException("Invalid username: " + username);
		}
		
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		auths.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		User user = new User(amitabhaUser.getUsername(), amitabhaUser.getPassword(), true, true, true, true, auths);
		
		return user;
	}

}
