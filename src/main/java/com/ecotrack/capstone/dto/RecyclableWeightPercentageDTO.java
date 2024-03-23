package com.ecotrack.capstone.dto;

import lombok.Data;

@Data
public class RecyclableWeightPercentageDTO {
    private String recyclableType;
    private Double totalWeight;
    private Double weightPercentage;

    public RecyclableWeightPercentageDTO(String recyclableType, Double totalWeight, Double weightPercentage) {
        this.recyclableType = recyclableType;
        this.totalWeight = totalWeight;
        this.weightPercentage = weightPercentage;
    }

    // Getters and setters
}
