package com.green.nowon.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "goods")
@Entity
public class GoodsEntity extends BaseDateEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long no;

    private String title;       //상품올릴때 제목
    @Lob
    private String specifications;  //상품상세
    @Lob
    private String productCare;    //주의사항
    private int price;
    private int stock;
    @Lob
    private String content;
    @Builder.Default
    @OneToMany(mappedBy = "goods")
    private List<GoodsImg> imgs = new ArrayList<>();

    public GoodsImg defImg(){
        for(GoodsImg img: imgs){
            if(img.isDefImg()) return img;
        }
        return imgs.get(0); //만약 대표이미지가 없으면
    }


}