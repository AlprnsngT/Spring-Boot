package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.entity.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.util.mapper.CategoryMapper;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getAllCategories() {

        List<Category> categoryList = categoryRepository.getAllCats();
        List<CategoryDto> resultList = CategoryMapper.mapCategoryListToCategoryDtoList(categoryList);

        return resultList;
    }

    @Override
    public CategoryDto getCategoryById(int category_Id) {
        Optional<Category> opetionalCategory = categoryRepository.findById(category_Id);
        if(opetionalCategory.isPresent()){
            Category category = opetionalCategory.get();
            CategoryDto categoryDto = CategoryMapper.mapCategoryToCategoryDto(category);
            return categoryDto;
        }
        return null;
    }

    @Override
    public boolean deleteCategoryById(int categoryId) {
        
        if(existCategoryById(categoryId)){
            categoryRepository.deleteById(categoryId);
            return true;
        }
        return false;
    }

    @Override
    public int addCategory(Category category) {
       categoryRepository.save(category);
       return category.getId();
    }

    @Override
    public Category updateCategory(Category categoryParam) {
        // boolean existCategoryById = existCategoryById(categoryParam.getId());
        // if(existCategoryById){
        //     Category categoryEntity = getCategoryById(categoryParam.getId());
        //     categoryEntity.setName(categoryParam.getName());
        //     categoryRepository.save(categoryEntity);
        //     return categoryEntity;
        // }
        
       return null;
    }

    @Override
    public List<Category> searchCategoryByName(String categoryName) {
        List<Category> categoryList = categoryRepository.findByNameIgnoreCase(categoryName);
        return categoryList;
    }


        @Override
    public List<Category> searchCategoryByName(String categoryName, int pageNo, int pageSize, Direction sortDirection,
            String sortProperty) {
        PageRequest pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortDirection,sortProperty));
        List<Category> categoryList = categoryRepository.findByName(categoryName, pageable);
        return categoryList;
    }

    @Override
    public boolean existCategoryById(int categoryId) {
        boolean existsById = categoryRepository.existsById(categoryId);
        return existsById;
    }

    
    
}
