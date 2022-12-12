package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {


    @GetMapping("/admin")
    public String adminHome() {
        return "adminpage/admin";
    }
    @GetMapping("/admin/goods/reg")
    public String adminGoodsreg() {
        return "adminpage/goods/reg";
    }
    @GetMapping("/admin/goods/list")
    public String adminGoodslist() {
        return "adminpage/goods/list";
    }

    @GetMapping("/admin/goods/{ino}")
    public String goodsupdate(@PathVariable long ino){
        //서비스처리해서 상세내용 모델에 담아서 디테일페이지로 가져갈듯?
        return "adminpage/goods/detail";
    }
}
