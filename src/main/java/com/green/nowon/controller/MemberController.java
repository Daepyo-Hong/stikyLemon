package com.green.nowon.controller;

import com.green.nowon.security.MyUserDetails;
import com.green.nowon.service.CartService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Log4j2
@Controller
public class MemberController {
    @Autowired
    CartService cartService;

    //장바구니로 이동
    @GetMapping("/members/cart")
    public String cart(Model model, @AuthenticationPrincipal MyUserDetails userDetails) {
        //카트 없으면 생성
        cartService.createCart(userDetails.getMno());
        //카트에 담긴 목록 불러와야함
        cartService.getCartList(userDetails.getMno(), model);
        return "views/user/cart";
    }
    //장바구니에 데이터 추가
    @ResponseBody
    @PostMapping("/members/cart")
    public void addCart( long goodsNo, long quantity, @AuthenticationPrincipal MyUserDetails userDetails){
        long mno = userDetails.getMno();
        cartService.createCart(mno);

        System.out.println(quantity);
        System.out.println(goodsNo);
        cartService.insertData(goodsNo, quantity, mno);
    }
    //장바구니 갯수 변경시 반영
    @ResponseBody
    @PostMapping("/members/cart/update")
    public void updateCart(long no, long quantity){
        System.out.println("Controller");
        System.out.println("no: "+no+"\nquantity : "+quantity);
        cartService.updateCart(no, quantity);
    }

    //장바구니 내역 삭제시
    @ResponseBody
    @DeleteMapping("/members/cart")
    public void deleteCartGoods(long no){
        cartService.deleteCartGoods(no);
    }

    
    //멤버 마이페이지관련 경로이동
    
    //주문목록페이지 이동
    @GetMapping("/members/myOrders")
    public String myOrders() {
    	return "mypage/myOrders";
    }
    //내정보페이지 이동
    @GetMapping("/members/myAccount")
    public String myAccount() {
    	return "mypage/myAccount";
    }
    //내배송지페이지 이동
    @GetMapping("/members/myAddresses")
    public String myAddresses() {
    	return "mypage/myAddresses";
    }
//  //내배송지페이지 에서 기본배송지로이동 이동
//    @GetMapping("/members/deliveriesBase")
//    public String deliveriesBase() {
//    	
//    	return "mypage/deliveries-base";
//    }
//    

}
