package com.green.nowon.controller;

import com.green.nowon.domain.dto.goods.OrderGoodsDTO;
import com.green.nowon.domain.dto.member.DeliveryInfoDTO;
import com.green.nowon.domain.dto.member.OrderInsertDTO;
import com.green.nowon.security.MyUserDetails;
import com.green.nowon.service.OrderService;
import com.green.nowon.service.impl.OrderServiceProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {

    @Autowired
    private OrderService service;

    //결제이후 처리과정에서 신규배송지일시 등록하는것
    @ResponseBody
    @PostMapping("/members/delivery")
    public long deliveryInfo(DeliveryInfoDTO dto, @AuthenticationPrincipal MyUserDetails userDetails) {
        return service.deliveryInfoSave(dto, userDetails.getEmail());
    }

    //상품디테일에서 구매하기 버튼 눌렀을 때
    @GetMapping("/members/order")
    public String orderPayment(OrderGoodsDTO dto, Model model) {
        service.orderGoods(dto, model);
        return "views/user/order-payment";
    }

    @ResponseBody
    @PostMapping("/members/order")
    public void orderSave(@RequestBody OrderInsertDTO dto, @AuthenticationPrincipal MyUserDetails userDetails) {
        System.out.println(">>>>> OrderInsertDTO:"+ dto);
        service.save(dto, userDetails.getEmail());
    }

    //배송지 목록 불러오는거
    //@ResponseBody 표기하지 않은 ajax요청입니다. response결과로 HTML페이지
    @GetMapping("/members/deliveries")
    public String deliveries(@AuthenticationPrincipal MyUserDetails userDetails, Model model) {
        service.deliveries(userDetails.getEmail(), model);
        return "views/user/deliveries";
    }
    //@ResponseBody 표기하지 않은 ajax요청입니다. response결과로 HTML페이지
    @GetMapping("/members/deliveries/base")
    public String baseOfdeliveries(@AuthenticationPrincipal MyUserDetails userDetails, Model model) {
        service.baseOfdeliveries(userDetails.getEmail(), model);
        return "views/user/deliveries-base";
    }
}
