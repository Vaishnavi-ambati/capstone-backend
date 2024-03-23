package com.ecotrack.capstone.controller;

import com.ecotrack.capstone.entity.CategoryEntity;
import com.ecotrack.capstone.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/")
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public CategoryEntity getCategoryById(@PathVariable Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public CategoryEntity createCategory(@RequestBody CategoryEntity category) {
        return categoryRepository.save(category);
    }

}