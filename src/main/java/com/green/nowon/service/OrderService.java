package com.green.nowon.service;

import org.springframework.ui.Model;

import com.green.nowon.domain.dto.goods.OrderGoodsDTO;
import com.green.nowon.domain.dto.member.DeliveryInfoDTO;

public interface OrderService {

	//void orderGoods(OrderGoodsDTO dto, Model model);

	long deliveryInfoSave(DeliveryInfoDTO dto, String email);

	void deliveries(String email, Model model);

	void baseOfdeliveries(String email, Model model);

	void allOfdeliveries(String email, Model model);

	

}
