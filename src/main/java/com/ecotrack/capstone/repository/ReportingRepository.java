package com.ecotrack.capstone.repository;

import com.ecotrack.capstone.dto.RecyclableWeightPercentageDTO;
import com.ecotrack.capstone.entity.WasteEntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportingRepository extends JpaRepository<WasteEntryEntity, Integer> {

    @Query(value = "SELECT " +
            "DATE_FORMAT(we.date, '%b-%y') AS month, " +
            "c.waste_type AS wasteType, " +
            "SUM(we.weight_in_pounds) AS wasteWeight, " +
            "SUM(r.revenue_in_dollars) AS recycledRevenue, " +
            "SUM(e.landfill_fee) AS landfillFee " +
            "FROM waste_entry we " +
            "INNER JOIN category c ON we.category_id = c.category_id " +
            "LEFT JOIN revenue r ON we.entry_id = r.waste_entry_id " +
            "LEFT JOIN expense e ON we.entry_id = e.waste_entry_id " +
            "WHERE we.date >= ?1 AND we.date < ?2 " +
            "GROUP BY DATE_FORMAT(we.date, '%Y-%m'), c.waste_type " +
            "ORDER BY we.date", nativeQuery = true)
    List<Object[]> findSummaryReportDataByFinancialYear(String startDate, String endDate);

    @Query(value = "SELECT c.waste_type, SUM(we.weight_in_pounds), " +
            "(SUM(we.weight_in_pounds) / (SELECT SUM(weight_in_pounds) FROM waste_entry WHERE we.date >= ?1 AND we.date < ?2) * 100) " +
            "FROM waste_entry we " +
            "INNER JOIN category c ON we.category_id = c.category_id " +
            "WHERE c.category_name = 'Recyclables' AND we.date >= ?1 AND we.date < ?2 " +
            "GROUP BY c.waste_type", nativeQuery = true)
    List<Object[]> findRecyclablesSummaryByWeightYearToDate(String startDate, String endDate);

    @Query(value = "SELECT c.waste_type, SUM(we.buyer_revenue), " +
            "(SUM(we.buyer_revenue) / (SELECT SUM(buyer_revenue) FROM waste_entry WHERE we.date >= ?1 AND we.date < ?2) * 100) " +
            "FROM waste_entry we " +
            "INNER JOIN category c ON we.category_id = c.category_id " +
            "WHERE c.category_name = 'Recyclables' AND we.date >= ?1 AND we.date < ?2 " +
            "GROUP BY c.waste_type", nativeQuery = true)
    List<Object[]> findRecyclablesSummaryByRevenueYearToDate(String startDate, String endDate);

    @Query(value = "SELECT c.category_name, SUM(we.weight_in_pounds), " +
            "(SUM(we.weight_in_pounds) / (SELECT SUM(weight_in_pounds) FROM waste_entry WHERE we.date >= ?1 AND we.date < ?2) * 100) " +
            "FROM waste_entry we " +
            "INNER JOIN category c ON we.category_id = c.category_id " +
            "WHERE we.date >= ?1 AND we.date < ?2 " +
            "GROUP BY c.category_name", nativeQuery = true)
    List<Object[]> findWasteSummaryByWeightYearToDate(String startDate, String endDate);

    @Query(value = "SELECT " +
            "DATE_FORMAT(we.date, '%b-%y') AS month, " +
            "c.waste_type AS wasteType, " +
            "SUM(we.weight_in_pounds) AS wasteWeight, " +
            "SUM(r.revenue_in_dollars) AS recycledRevenue, " +
            "(SUM(we.weight_in_pounds) / (SELECT SUM(weight_in_pounds) FROM waste_entry we WHERE we.date >= '2023-07-01' AND we.date < '2024-07-01') * 100) AS 'Weight_Percentages', " +
            "(SUM(we.buyer_revenue) / (SELECT SUM(buyer_revenue) FROM waste_entry we WHERE we.date >= '2023-07-01' AND we.date < '2024-07-01') * 100) AS 'Revenue_Percentages' " +
            "FROM waste_entry we " +
            "INNER JOIN category c ON we.category_id = c.category_id " +
            "LEFT JOIN revenue r ON we.entry_id = r.waste_entry_id " +
            "LEFT JOIN expense e ON we.entry_id = e.waste_entry_id " +
            "WHERE c.category_name = 'Recyclables'" +
            "GROUP BY DATE_FORMAT(we.date, '%Y-%m'), c.waste_type " +
            "ORDER BY we.date", nativeQuery = true)
    List<Object[]> findRecyclablesSummaryMonthly();

    @Query(value = "SELECT " +
            "DATE_FORMAT(we.date, '%b-%y') AS month, " +
            "c.category_name AS wasteType, " +
            "SUM(we.weight_in_pounds) AS wasteWeight, " +
            "(SUM(we.weight_in_pounds) / (SELECT SUM(weight_in_pounds) FROM waste_entry we WHERE we.date >= '2023-07-01' AND we.date < '2024-07-01') * 100) AS 'Weight_Percentages' " +
            "FROM waste_entry we " +
            "INNER JOIN category c ON we.category_id = c.category_id " +
            "GROUP BY DATE_FORMAT(we.date, '%Y-%m'), c.category_name " , nativeQuery = true)
    List<Object[]> findWasteWeightSummaryMonthly();
}