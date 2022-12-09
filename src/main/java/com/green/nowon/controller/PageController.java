package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping("/shop")
	public String shop(){
		return "views/main/shop";
	}
	@GetMapping("/qna")
	public String admin() {
		return "views/admin/qna";
	}

	@GetMapping("/members/cart")
	public String cart(Model model){
		model.addAttribute("list","value");
		return "views/user/cart";
	}

}
