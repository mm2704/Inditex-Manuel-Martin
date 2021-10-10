package com.inditex.manuelMartin.repository;

import com.inditex.manuelMartin.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    Price findFirstByStartDateBeforeAndEndDateAfterAndBrandIdAndProductIdOrderByPriorityDesc(LocalDateTime startDate, LocalDateTime endDate, Integer brandId, Integer productId);

    default Price findByStartDateBeforeAndEndDateAfter(LocalDateTime givenDate, Integer brandId, Integer productId) {
        return findFirstByStartDateBeforeAndEndDateAfterAndBrandIdAndProductIdOrderByPriorityDesc(givenDate, givenDate, brandId, productId);
    }
}
