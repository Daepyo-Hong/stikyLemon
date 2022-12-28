package com.green.nowon.service.impl;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.dto.goods.OrderGoodsDTO;
import com.green.nowon.domain.dto.goods.OrderGoodsListDTO;
import com.green.nowon.domain.dto.member.DeliveryInfoDTO;
import com.green.nowon.domain.dto.member.DeliveryListDTO;
import com.green.nowon.domain.entity.DeliveryEntityRepository;
import com.green.nowon.domain.entity.GoodsEntityRepository;
import com.green.nowon.domain.entity.MemberEntityRepository;
import com.green.nowon.service.OrderService;



@Service
public class OrderServiceProcess implements OrderService {

	@Autowired
	private GoodsEntityRepository GoodsRepo;
	
	@Autowired
	private DeliveryEntityRepository deliveryRepo;
	
	@Autowired
	private MemberEntityRepository memRepo;
	
	//회원의 모든 배송지중 기본배송지
	@Override
	public void baseOfdeliveries(String email, Model model) {
		model.addAttribute("base", deliveryRepo.findByBaseAndMember_email(true,email)
				.map(DeliveryListDTO::new)
				.orElseThrow()
				);
		
	}
	//회원의 모든 배송지
	@Override
	public void deliveries(String email, Model model) {
		model.addAttribute("list", deliveryRepo.findAllByMember_email(email).stream()
									.map(DeliveryListDTO::new)
									.collect(Collectors.toList())
				);
	}
	//주문결제라 주석처리함 
//	@Transactional
//	@Override
//	public void orderGoods(OrderGoodsDTO dto, Model model) {
//		model.addAttribute("list", GoodsRepo.findById(dto.getGoodsNo()).map(OrderGoodsListDTO::new)
//				.get()
//				.quantity(dto.getQuantity()));
//	}

	//멤버 이메일을 기준으로 배송지 데이터를 저장한다는뜻
	@Override
	public long deliveryInfoSave(DeliveryInfoDTO dto, String email) {
		return deliveryRepo.save(dto.toEntity()
				.base(deliveryRepo.countByMember_email(email)==0?true:false)//배송지정보가 없으면 base=true
				.member(memRepo.findByEmail(email).orElseThrow()))
				.getNo();
		
	}
	//이짱이 페이먼트 연결한것 배송지 등록창이 보이게끔!
	@Override
	public void allOfdeliveries(String email, Model model) {
		model.addAttribute("base", deliveryRepo.findByMember_email(email)
				.stream()
				.map(DeliveryListDTO::new)
				);
		
	}
	
	
	

	

	

	

}
