package com.utpscm.amitabha.user.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@RequestMapping("/logout.htm")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "login";
	}
	
	@RequestMapping(value="/login.action",method=RequestMethod.POST)
	public String login(@RequestParam(value="username", required=true) String username, @RequestParam(value="password", required=true)String password) {
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			return "index";
		} catch (AuthenticationException e) {
			return "login";
		}
	}
	
	@RequestMapping("/login.htm")
	public ModelAndView toLogin(String username, String password) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping("/secret.htm")
	public ModelAndView toSecret() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("secret");
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		mv.addObject("username", username);
		return mv;
	}

}
