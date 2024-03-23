package com.ecotrack.capstone.entity;

import jakarta.persistence.*;

import java.util.Set;
import lombok.Data;

@Data
@Entity
@Table(name = "buyer")
public class BuyerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "buyer_id")
    private Integer buyerId;

    private String buyerName;

    @OneToMany(mappedBy = "buyer")
    private Set<WasteEntryEntity> wasteEntries;

    // Getters and setters
}