package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.entity.Category;
import com.example.demo.service.CategoryService;




@RestController
@RequestMapping("api/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(value="")
    public List<CategoryDto> getAllCategories() {
        List<CategoryDto> categoryList = categoryService.getAllCategories();
        return categoryList;
    }

    @GetMapping(value="/searchByName/{name}")
    public List<Category> searchByName(@PathVariable("name") String name) {
        List<Category> categoryList = categoryService.searchCategoryByName(name);
        return categoryList;
    }

    
    
    
    
    
}
