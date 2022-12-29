package com.green.nowon.domain.dto.goods;

import com.green.nowon.domain.entity.GoodsEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderGoodsListDTO {
	private GoodsListDTO goods;

	private int quantity;

	//수량에따른 가격
	private int totPrice;

	public OrderGoodsListDTO quantity(int quantity) {
		this.quantity=quantity;
		this.totPrice=quantity*(goods.getPrice()-goods.getSPrice());
		return this;
	}
	//주문금액
	public OrderGoodsListDTO(GoodsEntity e){
		this.goods=new GoodsListDTO(e);
	}
}
