package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping("/signin")
	public String signin() {
		return "views/sign/signin";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "views/sign/signup";
	}
	@GetMapping("/admin")
	public String adminHome() {
		return "adminpage/admin";
	}
	
}
