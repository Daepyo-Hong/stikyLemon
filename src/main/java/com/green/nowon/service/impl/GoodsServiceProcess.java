package com.green.nowon.service.impl;

import com.green.nowon.domain.dto.goods.GoodsDetailImgDTO;
import com.green.nowon.domain.dto.goods.GoodsListDTO;
import com.green.nowon.domain.dto.goods.GoodsDetailDTO;
import com.green.nowon.domain.entity.*;
import com.green.nowon.utils.MyFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.green.nowon.domain.dto.goods.GoodsInsertDTO;
import com.green.nowon.service.GoodsService;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GoodsServiceProcess implements GoodsService{

	@Value("${file.location.temp}")
	private String locationTemp;

	@Value("${file.location.upload}")
	private String locationUpload;


	@Autowired
	GoodsEntityRepository goodsRepo;
	@Autowired
	CategoryGoodsEntityRepository cateGoodsRepo;
	@Autowired
	GoodsImgRepository imgRepo;
	@Autowired
	CategoryEntityRepository cateRepo;

	List<CategoryEntity> cates;


	//재귀메서드
	private void categoryList(CategoryEntity ca){
		if(ca==null)return;
		cates.add(ca);
		categoryList(ca.getParent());
	}

	@Transactional
	@Override
	public void goodsOfCategory(long cateNo, Model model) {
		//카테고리에 해당하는 상품들 모두
		cates=new ArrayList<>();
		categoryList(cateRepo.findById(cateNo).get());

		model.addAttribute("cates",cates);
		model.addAttribute("list", cateGoodsRepo.findAllByCategoryNo(cateNo)
				.stream()
				.map(GoodsListDTO::new)
				.collect(Collectors.toList()));

	}


	@Override
	public void save(GoodsInsertDTO dto) {
		//카테고리와 상품 등록
		//이미지 정보 등록, temp->실제 upload위치
		long[] categoryNo=dto.getCategoryNo();
		dto.toGoodsEntity();

		GoodsEntity entity= goodsRepo.save(dto.toGoodsEntity());
		for(long no:categoryNo) {
			cateGoodsRepo.save(CategoryGoodsEntity.builder()
					.goods(entity)
					.category(cateRepo.findById(no).get())
					.build());
		}

		dto.toItemListImgs(entity, locationUpload).forEach(imgRepo::save);
		//이미지 temp->temp->실제 upload위치
	}

	@Override
	public Map<String, String> fileTempUpload(MultipartFile gimg) {
		return MyFileUtils.fileUpload(gimg, locationTemp);
	}


	//관리자페이지 상품리스트 보여주기
	@Transactional
	@Override
	public void getList(Model model) {
		List<GoodsEntity> list = goodsRepo.findAll();
		model.addAttribute("list", list.stream()
				.map(GoodsListDTO::new).collect(Collectors.toList()));
	}

	//관리자페이지에서 상품 수정버튼 눌렀을 때 페이지 이동 전 객체담기
	@Transactional
	@Override
	public void update(long no, Model model) {
		GoodsEntity entity = goodsRepo.findById(no).orElseThrow();
		model.addAttribute("dto", new GoodsDetailDTO(entity));


		//카테고리정보도 가져가고, 뿌려주는것도 해야할 듯.

		//model.addAttribute("cate",);

		//이미지정보도 가져가고, 뿌려주는것도 해야할 듯.
		List<GoodsImg> result = imgRepo.findAllByGoodsNo(no);
		List<GoodsDetailImgDTO> imgList = result.stream()
				.map(GoodsDetailImgDTO::new)
				.collect(Collectors.toList());
		model.addAttribute("imgs",imgList);

	}
}
