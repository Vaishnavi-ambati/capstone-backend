package com.ecotrack.capstone.controller;

import com.ecotrack.capstone.entity.ExpenseEntity;
import com.ecotrack.capstone.entity.RevenueEntity;
import com.ecotrack.capstone.entity.WasteEntryEntity;
import com.ecotrack.capstone.repository.ExpenseRepository;
import com.ecotrack.capstone.repository.RevenueRepository;
import com.ecotrack.capstone.repository.WasteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waste-entries")
public class WasteEntryController {

    @Autowired
    private WasteRepository wasteEntryRepository;

    @Autowired
    private RevenueRepository revenueRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping("/")
    public List<WasteEntryEntity> getAllWasteEntries() {
        return wasteEntryRepository.findAll();
    }

    @GetMapping("/{id}")
    public WasteEntryEntity getWasteEntryById(@PathVariable Integer id) {
        return wasteEntryRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public WasteEntryEntity createWasteEntry(@RequestBody WasteEntryEntity wasteEntry) {
        WasteEntryEntity newEntry = wasteEntryRepository.save(wasteEntry);

        if(wasteEntry.getBuyer()!=null && wasteEntry.getLandfillFee() == 0){
            RevenueEntity newRevenue = new RevenueEntity();
            newRevenue.setWasteEntry(wasteEntry);
            newRevenue.setRevenueInDollars(wasteEntry.getBuyerRevenue());
            newRevenue.setBuyer(wasteEntry.getBuyer());
            newRevenue.setDate(wasteEntry.getDate());
            newRevenue.setWeightInPounds(wasteEntry.getWeightInPounds());

            revenueRepository.save(newRevenue);
        }
        else{
            ExpenseEntity newExpense = new ExpenseEntity();
            newExpense.setWasteEntry(wasteEntry);
            newExpense.setDate(wasteEntry.getDate());
            newExpense.setLandfillFee(wasteEntry.getLandfillFee());
            newExpense.setWeightInPounds(wasteEntry.getWeightInPounds());

            expenseRepository.save(newExpense);
        }


        System.out.println(newEntry);
        return newEntry;
    }

    @PutMapping("/{id}")
    public WasteEntryEntity updateWasteEntry(@PathVariable Integer id, @RequestBody WasteEntryEntity wasteEntryDetails) {
        return wasteEntryRepository.findById(id)
                .map(wasteEntry -> {
                    wasteEntry.setDate(wasteEntryDetails.getDate());
                    wasteEntry.setWeightInPounds(wasteEntryDetails.getWeightInPounds());
                    wasteEntry.setCategory(wasteEntryDetails.getCategory());
                    wasteEntry.setBuyer(wasteEntryDetails.getBuyer());
                    wasteEntry.setLandfillFee(wasteEntryDetails.getLandfillFee());
                    return wasteEntryRepository.save(wasteEntry);
                }).orElseGet(() -> {
                    wasteEntryDetails.setEntryId(id);
                    return wasteEntryRepository.save(wasteEntryDetails);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteWasteEntry(@PathVariable Integer id) {
        wasteEntryRepository.deleteById(id);
    }
}