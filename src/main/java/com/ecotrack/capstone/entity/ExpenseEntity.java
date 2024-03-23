package com.ecotrack.capstone.entity;

import jakarta.persistence.*;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "expense")
public class ExpenseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer expenseId;

    private Date date;
    private float weightInPounds;
    private float landfillFee;

    @ManyToOne
    @JoinColumn(name = "waste_entry_id", referencedColumnName = "entry_id")
    private WasteEntryEntity wasteEntry;

    // Getters and setters
}