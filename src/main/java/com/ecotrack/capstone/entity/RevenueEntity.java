package com.ecotrack.capstone.entity;

import jakarta.persistence.*;

import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "revenue")
public class RevenueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer revenueId;

    private Date date;
    private float weightInPounds;
    private float revenueInDollars;

    @ManyToOne
    @JoinColumn(name = "buyer_id", referencedColumnName = "buyer_id")
    private BuyerEntity buyer;

    @ManyToOne
    @JoinColumn(name = "waste_entry_id", referencedColumnName = "entry_id")
    private WasteEntryEntity wasteEntry;

    // Getters and setters
}
