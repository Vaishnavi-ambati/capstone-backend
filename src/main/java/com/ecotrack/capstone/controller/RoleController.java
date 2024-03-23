package com.ecotrack.capstone.controller;

import com.ecotrack.capstone.entity.RoleEntity;
import com.ecotrack.capstone.entity.UserEntity;
import com.ecotrack.capstone.repository.RoleRepository;
import com.ecotrack.capstone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/")
    public List<RoleEntity> getRoles() {
        return roleRepository.findAll();
    }

    @GetMapping("/{id}")
    public RoleEntity getRoleById(@PathVariable Integer id) {
        return roleRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public RoleEntity createRole(@RequestBody RoleEntity role) {
        return roleRepository.save(role);
    }
}
