package com.green.nowon.domain.dto.goods;

import com.green.nowon.domain.entity.CartGoodsDetail;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class OrderGoodsDTO {
    private long goodsNo;
    private long quantity;

    public OrderGoodsDTO(CartGoodsDetail e){
        this.goodsNo=e.getGoods().getNo();
        this.quantity=e.getQuantity();
    }
}

