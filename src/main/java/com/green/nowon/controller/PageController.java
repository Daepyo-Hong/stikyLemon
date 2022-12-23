package com.green.nowon.controller;

import com.green.nowon.domain.entity.GoodsEntityRepository;
import com.green.nowon.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @Autowired
    GoodsService goodsService;
    //shop 버튼 눌렀을 때
    @GetMapping("/comm/goods/list")
    public String shop(Model model) {
        //goodsService.findAllGoods(model);
        return "views/main/menu/shop";
    }

	//장바구니로 이동
	@GetMapping("/members/cart")
	public String cart(Model model){
		//임시 list 저장해놓은것
		model.addAttribute("list","value");
		return "views/user/cart";
	}
	@GetMapping("/faq-list")
	public String faqList() {
		return "views/admin/faq/faq-list";
	}

    @GetMapping("/comm/goods/detail") // goods gno{num}으로 수정 예정.
    public String goods() {
        return "views/goods/goodsDetailPage";
    }

    @GetMapping("/comm/contact") // goods gno{num}으로 수정 예정.
    public String contact() {
        return "views/main/contact";
    }


}
