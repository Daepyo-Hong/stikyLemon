package com.green.nowon.domain.dto.goods;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.green.nowon.domain.entity.BaseDateEntity;
import com.green.nowon.domain.entity.GoodsEntity;

import lombok.Setter;



public class GoodsDTO extends BaseDateEntity{
	
	@Id @Column(name = "GoodsDTO_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(nullable = false)
	private String title;
	
	
	@Column(nullable = false)
	private String content;
	
	
	@Column(nullable = false)
	private long price;
	
	
	@Column(nullable = false)
	private long stock;
	
	
	private List<GoodsImgDTO> goodsImgDTOList = new ArrayList<>();

    private List<Long> goodsImgIds  = new ArrayList<>();

    private static ModelMapper modelMapper = new ModelMapper();

//    public GoodsEntity createGoods(){
//    	GoodsEntity goods = GoodsEntity.builder()
//    			.content(this.content)
//                .ti
//    }(tle(title)
//                .stock(stock)
//                .price(price)
//                .build();
//        return goods;
//      //  return modelMapper.map(this, GoodsEntity.class);
//    }

//    public static GoodsDTO of(GoodsEntity goods ){
//        return modelMapper.map(goods , goodsImgIds);
//    }
//	
	
	//이미지파일
	
    
   

    
}