package com.example.demo.controller;

import java.util.List;

// logger için bu kullanılır
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.entity.Category;
import com.example.demo.model.vm.AddCategoryVm;
import com.example.demo.model.vm.UpdateCategoryVm;
import com.example.demo.service.CategoryService;
import com.example.demo.util.mapper.CategoryMapper;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @GetMapping(value = "")
    public List<CategoryDto> getAllCategories() {
        List<CategoryDto> categoryList = categoryService.getAllCategories();
        logger.info("Listeleme Başarılı");
        return categoryList;
    }
 @GetMapping(value = "/{id}")
    public CategoryDto getByCategoryId(@PathVariable("id") int id) {
        CategoryDto category = categoryService.getCategoryById(id);
        return category;
    }

    @GetMapping(value = "/searchByName/{name}")
    public List<Category> searchByName(@PathVariable("name") String name) {
        List<Category> categoryList = categoryService.searchCategoryByName(name);
        return categoryList;
    }

    @PostMapping(value = "")
    public int addCategory(@RequestBody AddCategoryVm categoryVm) {
        int recordedId = categoryService.addCategory(CategoryMapper.mapAddVmToDto(categoryVm));
        return recordedId;
    }

    @PutMapping(value = "")
    public CategoryDto updateCategory(@RequestBody UpdateCategoryVm categoryVm) {
        CategoryDto vm = categoryService.updateCategory(CategoryMapper.mapUpdateVmToDto(categoryVm));
        return vm;
    }

}
