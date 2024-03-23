package com.ecotrack.capstone.repository;

import com.ecotrack.capstone.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
