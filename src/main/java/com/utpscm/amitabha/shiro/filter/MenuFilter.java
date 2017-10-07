package com.utpscm.amitabha.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

public class MenuFilter extends AccessControlFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
		Subject subject = SecurityUtils.getSubject();
		
		if (!subject.isAuthenticated()) {
			return false;
		}
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		String uri = httpServletRequest.getRequestURI();//获取URI
		String basePath = httpServletRequest.getContextPath();//获取basePath
		if(null != uri && uri.startsWith(basePath)){
			uri = uri.replace(basePath, "");
			uri = uri.replace(".htm", "");
		}
		if(subject.isPermitted(uri)){
			return true;
		} else {
			return false;
		}
	}

	@Override
	protected boolean onAccessDenied(ServletRequest arg0, ServletResponse arg1) throws Exception {
		Subject subject = SecurityUtils.getSubject();
		
		if (subject.getPrincipal() == null) {
			//	redirect to login
		}
		return false;
	}

}
