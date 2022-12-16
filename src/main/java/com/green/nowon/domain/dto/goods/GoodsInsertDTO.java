package com.green.nowon.domain.dto.goods;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.green.nowon.domain.entity.BaseDateEntity;
import com.green.nowon.domain.entity.GoodsEntity;

import lombok.Setter;


@Setter
public class GoodsInsertDTO extends BaseDateEntity{
	
	@Id @Column(name = "GoodsInsertDTO_id")
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


	public GoodsEntity toEntity() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//이미지파일
	
	
	
	
	
    
   

    
}







