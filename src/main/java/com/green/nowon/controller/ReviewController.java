package com.green.nowon.controller;

import com.green.nowon.domain.dto.goods.ReviewDTO;
import com.green.nowon.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/comm/goods/detail/{gno}")
    public String review(@PathVariable Long gno, Model model, ReviewDTO dto) {
        reviewService.insertReview(gno, model, dto);
         return "redirect:/comm/goods/detail/"+gno;
    }

}
