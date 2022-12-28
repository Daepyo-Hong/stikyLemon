package com.green.nowon.domain.dto.cart;

import com.green.nowon.domain.entity.CartEntity;
import com.green.nowon.domain.entity.CartGoodsDetail;
import com.green.nowon.domain.entity.GoodsEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
public class CartGoodsListDTO {

    private long no;
    private long quantity;//수량
    private long goodsNo;
    private String defImg;  //사진
    private String title;
    private int price;

    public CartGoodsListDTO(CartGoodsDetail e){
        this.no = e.getNo();
        this.quantity = e.getQuantity();
        this.goodsNo = e.getGoods().getNo();
    }
}
