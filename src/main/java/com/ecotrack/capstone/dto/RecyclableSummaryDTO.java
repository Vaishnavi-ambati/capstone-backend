package com.ecotrack.capstone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecyclableSummaryDTO {

    private String month;
    private String recyclableType;
    private Double totalWeight;
    private Double weightPercentage;
    private Double totalRevenue;
    private Double revenuePercentage;

}
