package com.green.nowon.domain.dto.goods;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.green.nowon.domain.entity.BaseDateEntity;

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
	
	//이미지파일
	
	
	
	
	
    
   

    
}







