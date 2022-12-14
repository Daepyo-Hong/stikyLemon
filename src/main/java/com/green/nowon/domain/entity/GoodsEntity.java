package com.green.nowon.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SequenceGenerator(name = "Goods_gen_mem", sequenceName = "Goods_seq_mem", allocationSize = 1)
@Table(name = "GoodsEntity")
@Entity
public class GoodsEntity extends BaseDateEntity{
	
	@Id @Column(name = "Goods_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
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







