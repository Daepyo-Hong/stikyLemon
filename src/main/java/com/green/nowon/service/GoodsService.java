package com.green.nowon.service;

import com.green.nowon.domain.dto.goods.GoodsInsertDTO;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface GoodsService {

	void save(GoodsInsertDTO dto);

    Map<String, String> fileTempUpload(MultipartFile gimg);

    void goodsOfCategory(long cateNo, Model model);

    void getList(Model model);

    void update(long gno, Model model);

	void detail(long no, Model model);

}
