package com.ecotrack.capstone.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
@Table(name = "role")
public class RoleEntity {

    @Column(name = "role_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    private String roleName;

    @OneToMany(mappedBy = "role")
    private Set<UserEntity> users;

    // Getters and setters
}