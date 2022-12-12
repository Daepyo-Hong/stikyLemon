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
	@GetMapping("/faq-list")
	public String faqList() {
		return "views/admin/faq/faq-list";
	}

	@GetMapping("/goods001") // goods gno{num}으로 수정 예정.
	public String goods() {
		return "views/goods/goodsDetailPage";
	}

	@GetMapping("/main/contact") // goods gno{num}으로 수정 예정.
	public String contact() {
		return "views/main/contact";
	}


}
