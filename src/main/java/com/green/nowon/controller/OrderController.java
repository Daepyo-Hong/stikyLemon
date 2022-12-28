package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.nowon.domain.dto.goods.OrderGoodsDTO;
import com.green.nowon.domain.dto.member.DeliveryInfoDTO;
import com.green.nowon.security.MyUserDetails;
import com.green.nowon.service.OrderService;


@Controller
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	//이메일을 기준으로 배송지정보를 저장하겠다라는뜻
	@ResponseBody
	@PostMapping("/member/myAddresses")
	public long deliveryInfo(DeliveryInfoDTO dto, @AuthenticationPrincipal MyUserDetails userDetails) {
		return service.deliveryInfoSave(dto, userDetails.getEmail());
		
	}
	
//	@GetMapping("/member/ezzange")
//	public String orderPayment(OrderGoodsDTO dto, Model model) {
//		service.orderGoods(dto, model);
//		return "mypage/ezzange-payment";
//	}
	
	//@ResponseBody 표기하지 않은 ajax요청입니다. response결과로 HTML페이지
	@GetMapping("/member/myAddresses")
	public String deliveries(@AuthenticationPrincipal MyUserDetails userDetails, Model model) {
		service.deliveries(userDetails.getEmail(), model);
		return "mypage/myAddresses";
	}
	
	//@ResponseBody 표기하지 않은 ajax요청입니다. response결과로 HTML페이지
		@GetMapping("/member/ezzange")
		public String baseOfdeliveries(@AuthenticationPrincipal MyUserDetails userDetails, Model model) {
			service.allOfdeliveries(userDetails.getEmail(), model);
			return "mypage/ezzange-payment";
		}
	
		

}
