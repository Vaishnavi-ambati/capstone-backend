package com.ecotrack.capstone.controller;

import com.ecotrack.capstone.entity.BuyerEntity;
import com.ecotrack.capstone.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buyers")
public class BuyerController {

    @Autowired
    private BuyerRepository buyerRepository;

    @GetMapping("/")
    public List<BuyerEntity> getAllUsers() {
        return buyerRepository.findAll();
    }

    @GetMapping("/{id}")
    public BuyerEntity getUserById(@PathVariable Integer id) {
        return buyerRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public BuyerEntity createUser(@RequestBody BuyerEntity buyer) {
        return buyerRepository.save(buyer);
    }
}
