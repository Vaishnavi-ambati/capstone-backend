package com.ecotrack.capstone.entity;

import jakarta.persistence.*;
import java.util.Date;import lombok.Data;

@Data
@Entity
@Table(name = "waste_entry")
public class WasteEntryEntity {

    @Id
    @Column(name = "entry_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer entryId;
    private Date date;
    private float weightInPounds;
    private float buyerRevenue;
    private float landfillFee;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "buyer_id", referencedColumnName = "buyer_id")
    private BuyerEntity buyer;

    // Getters and setters
}