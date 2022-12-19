package com.green.nowon.controller;

import com.green.nowon.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.green.nowon.domain.dto.goods.GoodsInsertDTO;
import com.green.nowon.service.GoodsService;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Controller
public class AdminController {

	@Autowired
	private GoodsService goodsService;

    @Autowired
    private CategoryService categoryService;

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
	@PostMapping("/admin/goods/reg")
	public String adminGoodsUpload(GoodsInsertDTO dto) {
		//등록하면 dto에 업데이트! 하고 리스트로 리턴
        goodsService.save(dto);
		return "redirect:/admin/goods/list";
	}
//상품조회페이지 이동
    @GetMapping("/admin/goods/list")
    public String adminGoodslist(Model model) {
        goodsService.getList(model);
        return "adminpage/goods/list";
    }
//관리자-상품-수정페이지로 이동
    @GetMapping("/admin/goods/{gno}")
    public String goodsUpdate(@PathVariable long gno, Model model){
        //서비스처리해서 상세내용 모델에 담아서 디테일페이지로 가져갈듯?
        goodsService.update(gno,model);
        return "adminpage/goods/detail";
    }
//관리자페이지에서 관리자-게시글조회페이지로 이동
	@GetMapping("/admin/qna/list")
	public String adminQnAlist(){
	    return "adminpage/qna/admin-qnalist";
	}

    //카테고리등록페이지로 이동
    @GetMapping("/admin/category/reg")
    public String categoryReg(){
        return "adminpage/category/reg";
    }
    //카테고리 입력후 등록할 시 카테고리레파지토리 이용해서 저장.
    @PostMapping("/admin/category/reg")
    public String category(String[] name) {
        categoryService.save(name);
        return "adminpage/category/reg";
    }

    @ResponseBody//응답데이터를 json타입으로 리턴합니다.
    @PostMapping("/admin/temp-upload")
    public Map<String, String> tempUpload(MultipartFile gimg) {
        return goodsService.fileTempUpload(gimg);
    }

}