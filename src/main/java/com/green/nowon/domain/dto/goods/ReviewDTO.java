package com.green.nowon.domain.dto.goods;

import com.green.nowon.domain.entity.ReviewEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewDTO {
    private String text;
    private long rate;
    private long goodsNo;

}
