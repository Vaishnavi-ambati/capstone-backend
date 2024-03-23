package com.ecotrack.capstone.repository;


import com.ecotrack.capstone.entity.WasteEntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WasteRepository extends JpaRepository<WasteEntryEntity, Integer> {
}
