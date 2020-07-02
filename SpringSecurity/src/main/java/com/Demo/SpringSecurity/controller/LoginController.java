package com.Demo.SpringSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String showLoginForm() {
		return "loginForm.jsp";
	}
	
	@RequestMapping("/access-denied")
	public String showAccessDeniedPage() {
		return "access-denied.jsp";
	}
	
}
