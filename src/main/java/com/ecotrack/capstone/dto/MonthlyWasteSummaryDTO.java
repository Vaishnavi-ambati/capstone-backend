package com.ecotrack.capstone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MonthlyWasteSummaryDTO {
    private String month;
    private String wasteType;
    private Double wasteWeight;
    private Double wastePercentage;
}
