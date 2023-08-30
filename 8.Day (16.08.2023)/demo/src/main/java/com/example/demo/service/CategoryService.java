package com.example.demo.service;

import java.util.List;

import com.example.demo.model.entity.Category;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(int category_Id);

    int addCategory(Category category);

    Category updateCategory(Category category);

    boolean deleteCategoryById(int categoryId);

    List<Category> searchCategoryByName(String categoryName);

    boolean existsCategoryById(int categoryId);

}
