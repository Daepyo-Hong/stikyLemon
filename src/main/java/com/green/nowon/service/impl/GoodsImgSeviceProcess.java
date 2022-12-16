package com.green.nowon.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.green.nowon.domain.entity.GoodsEntityRepository;
import com.green.nowon.domain.entity.GoodsImgEntityRepository;
import com.green.nowon.service.GoodsImgSevice;

@Service
public class GoodsImgSeviceProcess implements GoodsImgSevice{

	@Autowired
	private GoodsImgEntityRepository  goodsImgRepository;
	@Autowired
	private GoodsEntityRepository goodsRepository;
	
	@Value("${multipart.upload.path}")
	private String PATH;

	@Transactional
	@Override
	public void delete(String imgUrl) {
		
		//db에서 삭제, 업로드폴더에서도 삭제
		String[] strs=imgUrl.split("[/]");// "/"사용해도 되요
		for(String str :strs) {
			System.out.println("str : "+str);
		}
		
		String fileName=strs[strs.length-1];
		
		//GoodsImg deleteImg=goodsImgRepository.findByUrlAndName(PATH,fileName).orElseThrow();
		//goodsImgRepository.delete(deleteImg);
		
		//삭제쿼리메서드 생성시 @Transactional적용해서 삭제가능합니다.
		goodsImgRepository.deleteByUrlAndNewName(PATH,fileName);
		//
	}
}
