package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.green.nowon.domain.dto.goods.GoodsInsertDTO;
import com.green.nowon.service.GoodsService;

@Controller
public class AdminController {

	@Autowired
	private GoodsService service;

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
		service.update(dto);
		return "redirect:/admin/goods/list";
	}
//상품조회페이지 이동
    @GetMapping("/admin/goods/list")
    public String adminGoodslist() {
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


}