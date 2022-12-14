package com.green.nowon.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@SequenceGenerator(name = "GoodsImg_gen_mem", sequenceName = "GoodsImg_seq_mem", allocationSize = 1)
@Table(name = "GoodsImgEntity")
@Entity
public class GoodsImgEntity extends BaseDateEntity{

    @Id
    @Column(name ="Goods_img_id")//이걸통해 이미지를 가져올 수 있도록 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imgName;//로컬 저장소에 저장할 이름

    private String originImgName;//원본 이름을 저장

    private String imgUrl;//이미지 정보 
    //대표 이미지 여부
    private String defImgY;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_id")
    private GoodsEntity goodsEntity;

   

  
}