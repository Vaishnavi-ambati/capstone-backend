package com.ecotrack.capstone.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RevenueReportDTO {

    private Date saleDate;
    private String recyclableType;
    private float weightInPounds;
    private String buyerName;
    private float revenueInDollars;

    public RevenueReportDTO(Date saleDate, String recyclableType, float weightInPounds, String buyerName, float revenueInDollars) {
        this.saleDate = saleDate;
        this.recyclableType = recyclableType;
        this.weightInPounds = weightInPounds;
        this.buyerName = buyerName;
        this.revenueInDollars = revenueInDollars;
    }
}
