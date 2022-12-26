package com.green.nowon.service.impl;

import com.green.nowon.domain.dto.goods.ReviewDTO;
import com.green.nowon.service.ReviewService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ReviewServiceProcess implements ReviewService {

    @Override
    public void insertReview(Long gno, Model model, ReviewDTO dto) {
    }
}
