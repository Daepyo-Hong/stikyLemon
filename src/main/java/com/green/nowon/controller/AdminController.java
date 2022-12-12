package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

//어드민페이지 이동
    @GetMapping("/admin")
    public String adminHome() {
        return "adminpage/admin";
    }
//상품등록페이지 이동
    @GetMapping("/admin/goods/reg")
    public String adminGoodsreg() {
        return "adminpage/goods/reg";
    }
//상품조회페이지 이동
    @GetMapping("/admin/goods/list")
    public String adminGoodslist() {
        return "adminpage/goods/list";
    }

    @GetMapping("/admin/goods/{ino}")
    public String goodsupdate(@PathVariable long ino){
        //서비스처리해서 상세내용 모델에 담아서 디테일페이지로 가져갈듯?
        return "adminpage/goods/detail";
    }
//상품등록!
//    @PostMapping("/admin/goods/list")
//    public String adminGoodsslist() {
//        return "adminpage/goods/list";
//    }
}
