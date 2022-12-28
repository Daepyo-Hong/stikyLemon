package com.green.nowon.service;

import com.green.nowon.domain.dto.goods.OrderGoodsDTO;
import com.green.nowon.domain.dto.member.DeliveryInfoDTO;
import com.green.nowon.domain.dto.member.OrderInsertDTO;
import org.springframework.ui.Model;

public interface OrderService {
    void orderGoods(OrderGoodsDTO dto, Model model);

    void baseOfdeliveries(String email, Model model);

    void deliveries(String email, Model model);

    long deliveryInfoSave(DeliveryInfoDTO dto, String email);

    void save(OrderInsertDTO dto, String email);

    void allOfdeliveries(String email, Model model);
}