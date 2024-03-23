package com.ecotrack.capstone.controller;

import com.ecotrack.capstone.dto.*;
import com.ecotrack.capstone.repository.ReportingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/summary-report")
public class ReportingController {

    @Autowired
    private ReportingRepository reportingRepository;

    @GetMapping("/financial-year")
    public List<MonthlySummaryDTO> getSummaryReportForFinancialYear() {
        String startDate = "2023-07-01"; // Start of the financial year
        String endDate = "2024-06-30";   // End of the financial year
        List<Object[]> reportData = reportingRepository.findSummaryReportDataByFinancialYear(startDate, endDate);

        return reportData.stream().map(data -> new MonthlySummaryDTO(
                (String) data[0], // month
                (String) data[1], // wasteType
                (Double) data[2], // wasteWeight
                (Double) data[3], // recycledRevenue
                (Double) data[4]  // landfillFee
        )).collect(Collectors.toList());
    }

    @GetMapping("/recyclable-weight")
    public List<RecyclableWeightPercentageDTO> getRecyclablesSummaryByWeightYearToDate(
            @RequestParam String startDate,
            @RequestParam String endDate
    ) {

        List<Object[]> reportData = reportingRepository.findRecyclablesSummaryByWeightYearToDate(startDate, endDate);

        return reportData.stream().map(data -> new RecyclableWeightPercentageDTO(
                (String) data[0], // recyclableType
                (Double) data[1], // totalWeight
                (Double) data[2] // weightPercentage
        )).collect(Collectors.toList());
    }

    @GetMapping("/recyclable-revenue")
    public List<RecyclableRevenuePercentageDTO> getRecyclablesSummaryByRevenueYearToDate(
            @RequestParam String startDate,
            @RequestParam String endDate
    ) {

        List<Object[]> reportData = reportingRepository.findRecyclablesSummaryByRevenueYearToDate(startDate, endDate);

        return reportData.stream().map(data -> new RecyclableRevenuePercentageDTO(
                (String) data[0], // recyclableType
                (Double) data[1], // totalRevenue
                (Double) data[2] // revenuePercentage
        )).collect(Collectors.toList());
    }

    @GetMapping("/waste-weight")
    public List<RecyclableWeightPercentageDTO> getWasteByWeightYearToDate(
            @RequestParam String startDate,
            @RequestParam String endDate
    ) {

        List<Object[]> reportData = reportingRepository.findWasteSummaryByWeightYearToDate(startDate, endDate);

        return reportData.stream().map(data -> new RecyclableWeightPercentageDTO(
                (String) data[0], // recyclableType
                (Double) data[1], // totalRevenue
                (Double) data[2] // revenuePercentage
        )).collect(Collectors.toList());
    }

    @GetMapping("/recyclable-sumamry")
    public List<RecyclableSummaryDTO> getRecyclablesSummaryMonthly() {

        List<Object[]> reportData = reportingRepository.findRecyclablesSummaryMonthly();

        return reportData.stream().map(data -> new RecyclableSummaryDTO(
                (String) data[0], // month
                (String) data[1], // recyclableType
                (Double) data[2], // totalWeight
                (Double) data[3], // weightPercentage
                (Double) data[4], // totalRevenue
                (Double) data[5] // revenuePercentage
        )).collect(Collectors.toList());
    }

    @GetMapping("/waste-sumamry")
    public List<MonthlyWasteSummaryDTO> getWasteSummaryMonthly() {

        List<Object[]> reportData = reportingRepository.findWasteWeightSummaryMonthly();

        return reportData.stream().map(data -> new MonthlyWasteSummaryDTO(
                (String) data[0], // month
                (String) data[1], // recyclableType
                (Double) data[2], // totalWeight
                (Double) data[3] // weightPercentage
        )).collect(Collectors.toList());
    }
}