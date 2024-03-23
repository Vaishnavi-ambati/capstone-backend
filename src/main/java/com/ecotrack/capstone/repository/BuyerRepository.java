package com.ecotrack.capstone.repository;

import com.ecotrack.capstone.entity.BuyerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<BuyerEntity, Integer> {
}
