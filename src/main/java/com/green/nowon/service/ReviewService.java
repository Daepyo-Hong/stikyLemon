package com.green.nowon.service;

import com.green.nowon.domain.dto.goods.ReviewDTO;
import org.springframework.ui.Model;

public interface ReviewService {

    void insertReview(Long gno, Model model, ReviewDTO dto);
}
