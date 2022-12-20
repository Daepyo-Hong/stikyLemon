package com.green.nowon.domain.dto.goods;

import com.green.nowon.domain.entity.CategoryGoodsEntity;
import com.green.nowon.domain.entity.GoodsEntity;
import lombok.Data;
import net.bytebuddy.asm.Advice;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Data
public class GoodsListDTO {

    private long no;
    private String title;       //상품명
    private String specifications;  //상품상세
    private String productCare;    //주의사항
    private int price;
    private int stock;

    private LocalDateTime updatedDate;
    private String defImgUrl;

    public GoodsListDTO(GoodsEntity e){
        this.no=e.getNo();
        this.title=e.getTitle();
        this.specifications=e.getSpecifications();
        this.productCare=e.getProductCare();
        this.price=e.getPrice();
        this.stock=e.getStock();
        this.updatedDate=e.getUpdatedDate();
        this.defImgUrl=e.defImg().getUrl()+e.defImg().getNewName();
    }
    public GoodsListDTO(CategoryGoodsEntity cie){
        this(cie.getGoods());
    }
}