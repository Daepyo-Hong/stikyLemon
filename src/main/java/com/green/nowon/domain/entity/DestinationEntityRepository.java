package com.green.nowon.domain.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationEntityRepository extends JpaRepository<DestinationEntity,Long> {
}
