package com.green.nowon.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//@ToString(exclude = "goods")
@DynamicUpdate
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SequenceGenerator(name = "gen_seq_img", sequenceName = "seq_img", allocationSize = 1)
@Table(name = "GoodsImgEntity")
@Entity
public class GoodsImgEntity extends BaseDateEntity{

    @Id
    @Column(name ="GoodsImg_id")//이걸통해 이미지를 가져올 수 있도록 
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(nullable = false)
    private String imgName;//로컬 저장소에 저장할 이름
    
    @Column(nullable = false)
    private String originImgName;//원본 이름을 저장
    
    @Column(nullable = false)
    private String imgUrl;//이미지 정보 
    
    @Column(nullable = false)//이미지 사이즈
	private long size;
    
    //대표 이미지 여부
    private boolean  defImgY;

    
    ///대표이미지를 세팅해주는 편의메서드
    public GoodsImgEntity def(boolean defImgY) {
		this.defImgY=defImgY;
		return this;

   
    }
  
}