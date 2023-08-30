package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.entity.Category;

public interface CategoryService {

    List<CategoryDto> getAllCategories();
    CategoryDto getCategoryById(int category_Id) throws NotFoundException;
    boolean deleteCategoryById(int categoryId);
    boolean existsCategoryById(int categoryId);
    int addCategory(CategoryDto category);
    CategoryDto updateCategory(CategoryDto category);
    List<Category> searchCategoryByName(String categoryName);
    List<Category> searchCategoryByName(String categoryName,int pageNo,int pageSize,Direction sortDirection,String sortProperty);
    
}
