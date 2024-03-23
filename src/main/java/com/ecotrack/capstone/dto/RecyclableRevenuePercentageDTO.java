package com.ecotrack.capstone.dto;

import lombok.Data;

@Data
public class RecyclableRevenuePercentageDTO {

    private String recyclableType;
    private Double totalRevenue;
    private Double revenuePercentage;

    public RecyclableRevenuePercentageDTO(String recyclableType, Double totalWeight, Double weightPercentage) {
        this.recyclableType = recyclableType;
        this.totalRevenue = totalWeight;
        this.revenuePercentage = weightPercentage;
    }
}
