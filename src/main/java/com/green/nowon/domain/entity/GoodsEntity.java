package com.green.nowon.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import antlr.collections.impl.Vector;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@ToString(exclude = "imgs")
@DynamicUpdate
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SequenceGenerator(name = "gen_seq_good", sequenceName = "seq_good", allocationSize = 1)
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
	//양방향설정
		@JoinColumn(name = "Goods_id")
		@Builder.Default
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		List<GoodsImgEntity> imgs=new Vector<>();
		
		public String defImgUrl() {
			GoodsImgEntity defImg=imgs.get(0);
			return defImg.getImgUrl()+defImg.getImgName();
		}
		
		//이미지 삽입 편의메서드
		public GoodsEntity addImg(GoodsImgEntity img) {
			imgs.add(img);
			return this;
		}
		
		//대표이미지만 추출하는 편의메서드
		public GoodsImgEntity defImg() {
			for(GoodsImgEntity img:imgs) {
				if(img.isDefImgY()==true)
					return img;
			}
			return null;
		}
}







