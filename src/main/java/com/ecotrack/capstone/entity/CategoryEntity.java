package com.ecotrack.capstone.entity;

import jakarta.persistence.*;

import java.util.Set;

import lombok.Data;

@Data
@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    private String categoryName;
    private String wasteType;
    private String subWasteType;

    @OneToMany(mappedBy = "category")
    private Set<WasteEntryEntity> wasteEntries;

    // Getters and setters
}
