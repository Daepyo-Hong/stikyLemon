package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping("/shop")
	public String shop(){
		return "views/main/shop";
	}

	@GetMapping("/signin")
	public String signin() {
		return "views/sign/signin";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "views/sign/signup";
	}
	
}
