package com.green.nowon.domain.dto.goods;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;

import com.green.nowon.domain.entity.CategoryGoodsEntity;
import com.green.nowon.domain.entity.GoodsEntity;
import com.green.nowon.utils.MyFileUtils;

import lombok.Data;

@Data
public class GoodsDetailDTO {

	private long no;
	private String title;
	private String content;
	private int price;
	private int stock;
	
	//이미지 대표이미지
	private String defImgUrl;
	
	private List<GoodsListImgDTO> imgs;

	public GoodsDetailDTO(GoodsEntity e) {
		this.no = e.getNo();
		this.title = e.getTitle();
		this.content =e.getContent();
		this.price = e.getPrice();
		this.stock = e.getStock();
		//List<ItemListImg>
		imgs=e.getImgs().stream()
				.map(GoodsListImgDTO::new)
				.collect(Collectors.toList());
		
		this.defImgUrl = e.defImg().getUrl()+e.defImg().getNewName();
	}
	public GoodsDetailDTO(CategoryGoodsEntity cie) {
		this(cie.getGoods());
	}
	
	
}
