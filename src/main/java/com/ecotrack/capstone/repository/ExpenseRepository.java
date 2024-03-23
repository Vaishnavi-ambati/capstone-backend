package com.ecotrack.capstone.repository;

import com.ecotrack.capstone.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Integer> {
}
