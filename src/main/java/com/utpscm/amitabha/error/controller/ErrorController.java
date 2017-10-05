package com.utpscm.amitabha.error.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

	@RequestMapping("/403.htm")
	public ModelAndView noAuth() {
		ModelAndView mv = new ModelAndView("403");
		return mv;
	}
}
