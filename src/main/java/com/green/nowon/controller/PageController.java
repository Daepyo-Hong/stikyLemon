package com.green.nowon.controller;

import com.green.nowon.security.MyUserDetails;
import com.green.nowon.service.CartService;
import com.green.nowon.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @Autowired
    GoodsService goodsService;



    //shop 버튼 눌렀을 때
    @GetMapping("/comm/goods/list")
    public String shop(Model model) {
        goodsService.findAllGoods(model);
        return "views/main/shop";
    }



    @GetMapping("/faq-list")
    public String faqList() {
        return "views/admin/faq/faq-list";
    }

    //(유저) 상품디테일페이지이동
    @GetMapping("/comm/goods/detail/{no}") // goods gno{num}으로 수정 예정.
    public String goods(@PathVariable long no, Model model) {
        goodsService.adminDetail(no, model);
        return "views/goods/goodsDetailPage";
    }

    @GetMapping("/comm/contact") // goods gno{num}으로 수정 예정.
    public String contact() {
        return "views/main/contact";
    }


}
