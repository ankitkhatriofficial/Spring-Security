package com.Demo.SpringSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

	@RequestMapping("/")
	public String index() {
		return "home.jsp";
	}
	
	@RequestMapping("/leaders")
	public String showLeaders(){
		return "leaders.jsp";
	}
	
	@RequestMapping("/systems")
	public String showAdmins(){
		return "systems.jsp";
	}
}
