package com.utpscm.amitabha.shiro.token;

import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.utpscm.amitabha.role.service.RoleService;
import com.utpscm.amitabha.user.model.User;
import com.utpscm.amitabha.user.service.UserService;

public class UserRealm extends AuthorizingRealm{
	
	@Resource
	private UserService userService;
	
	@Resource
	private RoleService roleService;
	
	@Override
	public String getName() {
		return "userRealm";
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		String username = (String) principals.getPrimaryPrincipal();
		Set<String> roles = roleService.queryRolesByUsername(username);
		info.setRoles(roles);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
		String username = (String) authToken.getPrincipal();
		char[] pw = (char[]) authToken.getCredentials();
		String password = new String(pw);
		User user = userService.login(username, password);
		if (user == null) {
			//	user doesn't exist or password incorrect
			throw new AuthenticationException("帐号或密码不正确！");
		} else {
			return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
		}
	}
}
