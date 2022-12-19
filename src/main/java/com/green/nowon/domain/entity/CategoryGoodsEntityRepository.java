package com.green.nowon.domain.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface CategoryGoodsEntityRepository extends JpaRepository<CategoryGoodsEntity,Long> {
    List<CategoryGoodsEntity> findAllByCategoryNo(long cateNo);
}
