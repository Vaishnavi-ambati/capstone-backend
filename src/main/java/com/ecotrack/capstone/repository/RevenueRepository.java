package com.ecotrack.capstone.repository;

import com.ecotrack.capstone.dto.RevenueReportDTO;
import com.ecotrack.capstone.entity.RevenueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface RevenueRepository extends JpaRepository<RevenueEntity, Integer> {

    @Query("SELECT new com.ecotrack.capstone.dto.RevenueReportDTO(r.date, c.categoryName, r.weightInPounds, b.buyerName, r.revenueInDollars) " +
            "FROM RevenueEntity r " +
            "JOIN r.wasteEntry we " +
            "JOIN we.category c " +
            "JOIN r.buyer b " +
            "WHERE c.wasteType = :wasteType AND r.date BETWEEN :startDate AND :endDate " +
            "ORDER BY r.date ASC")
    List<RevenueReportDTO> findRevenueReportByRecyclingSubcategories(String wasteType, Date startDate, Date endDate);
}
