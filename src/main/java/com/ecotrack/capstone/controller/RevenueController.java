package com.ecotrack.capstone.controller;

import com.ecotrack.capstone.entity.RevenueEntity;
import com.ecotrack.capstone.repository.RevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/revenue")
public class RevenueController {

    @Autowired
    private RevenueRepository revenueRepository;

    @GetMapping("/")
    public List<RevenueEntity> getAllRevenue() {
        return revenueRepository.findAll();
    }

    @GetMapping("/{id}")
    public RevenueEntity getRevenueById(@PathVariable Integer id) {
        return revenueRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public RevenueEntity createRevenue(@RequestBody RevenueEntity revenue) {
        return revenueRepository.save(revenue);
    }


}