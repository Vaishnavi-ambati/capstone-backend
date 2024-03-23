package com.ecotrack.capstone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MonthlySummaryDTO {
    private String month;
    private String wasteType;
    private Double wasteWeight;
    private Double recycledRevenue;
    private Double landfillFee;

    // Getters and setters
}