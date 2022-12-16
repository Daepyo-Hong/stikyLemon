package com.green.nowon.service;

import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.green.nowon.domain.dto.goods.GoodsInsertDTO;

public interface GoodsService {

	

	void save(GoodsInsertDTO dto);

	Map<String, String> fileTempUpload(MultipartFile gimg);

	String tempUpload(MultipartFile img);

	void save(GoodsInsertDTO dto, MultipartFile[] imgs, String[] newName);

	void save(GoodsInsertDTO dto, MultipartFile[] imgs);

	void findAll(Model model);

	

}
