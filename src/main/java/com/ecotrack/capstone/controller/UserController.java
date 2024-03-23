package com.ecotrack.capstone.controller;

import com.ecotrack.capstone.entity.UserEntity;
import com.ecotrack.capstone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userRepository.save(user);
    }

}