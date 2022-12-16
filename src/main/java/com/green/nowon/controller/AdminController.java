package com.green.nowon.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.green.nowon.domain.dto.goods.GoodsInsertDTO;
import com.green.nowon.service.GoodsImgSevice;
import com.green.nowon.service.GoodsService;

@Controller
public class AdminController {

	@Autowired
	private GoodsService service;
	
	@Autowired
	private GoodsImgSevice imgService;

//어드민페이지 이동
    @GetMapping("/admin")
    public String adminHome() {
        return "adminpage/admin";
    }
//상품등록페이지 이동
    @GetMapping("/admin/goods/reg")
    public String adminGoodsreg() {
        return "adminpage/goods/reg";
    }
//상품등록처리!
	@PostMapping("/admin/goods/upload")
	public String adminGoodsUpload(GoodsInsertDTO dto) {
		//등록하면 dto에 업데이트! 하고 리스트로 리턴
		service.save(dto);
		return "redirect:/admin/goods/list";
	}
//관리자상품등록페이지에서 상품등록을 위해 상품정보를 입력한 후 
//관리자상품조회페이지 이동하면 모델객체에다가 상품정보랑 상품이미지를 받아서 보여주는 기능 처리 
	@GetMapping("/admin/goods/list")
	public String goods(Model model){	//상품 등록시 데이터가 저장될 곳
	    model.addAttribute("goods", new GoodsInsertDTO());
	    return "adminpage/goods/list";
	}
//관리자-상품-수정페이지로 이동
    @GetMapping("/admin/goods/detail")
    public String goodsUpdate(){
        //서비스처리해서 상세내용 모델에 담아서 디테일페이지로 가져갈듯?
        return "adminpage/goods/detail";
    }
//관리자페이지에서 관리자-게시글조회페이지로 이동
	@GetMapping("/admin/qna/list")
	public String adminQnAlist(){
	    return "adminpage/qna/admin-qnalist";
	}
	
//	
	@ResponseBody //응답데이터를 json타입으로 리턴합니다. 
	@PostMapping("/admin/temp-upload")
	public Map<String,String> tempUpload(MultipartFile gimg) {
		//System.out.println(">>>"+gimg.getOriginalFilename());
		return service.fileTempUpload(gimg);
	}
	
//
	@ResponseBody
	@DeleteMapping("/admin/goods-img")
	public void delete(String imgUrl) {//변수이름이 ajax data의 key와 일치
		
		System.out.println("imgUrl: "+imgUrl);
		imgService.delete(imgUrl);
		
	}

}