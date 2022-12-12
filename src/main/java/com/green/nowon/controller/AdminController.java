package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
