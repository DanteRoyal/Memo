package com.example.demo.category.controller;

import com.example.demo.category.CategoryService;
import com.example.demo.category.dto.CategoryDTO;
import com.example.demo.category.entity.Category;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public Category createCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.createCategory(categoryDTO);
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/")
    public Page<Category> getCategories(Pageable pageable, @RequestParam String keyword) {
        return categoryService.getCategories(pageable, keyword);
    }
}
