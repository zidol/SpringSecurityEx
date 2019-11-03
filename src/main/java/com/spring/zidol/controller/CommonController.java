package com.spring.zidol.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommonController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		logger.info("access Denied : " + auth);
		model.addAttribute("msg", "Access Denied");
	}
	
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		logger.info("error : " + error);
		logger.info("logout : " + logout);
		
		if(error != null) {
			model.addAttribute("error", "Login Error Check Your Account");
		}
		
		if(logout != null) {
			model.addAttribute("logout", "Logout!!");
		}
	}
	
	@GetMapping("/customLogout")
	public void logoutGet() {
		logger.info("custom logout");
	}
	
	@PostMapping("/customLogout")
	public void logoutPost() {
		logger.info("custom logout");
	}
	
}
