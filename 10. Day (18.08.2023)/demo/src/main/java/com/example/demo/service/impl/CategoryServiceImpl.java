package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.controller.CategoryController;
import com.example.demo.exception.NotFoundException;
import com.example.demo.exception.UserBasedException;
import com.example.demo.exception.category.CategoryNotFoundException;
import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.entity.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.util.mapper.CategoryMapper;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Override
    public List<CategoryDto> getAllCategories() {

        List<Category> categoryList = categoryRepository.getAllCats();
        List<CategoryDto> resultList = CategoryMapper
                .mapCategoryListToCategoryDtoList(categoryList);
        return resultList;
    }

    @Override
    public CategoryDto getCategoryById(int category_Id) throws NotFoundException {
        Optional<Category> opetionalCategory = categoryRepository.findById(category_Id);
        if (!opetionalCategory.isPresent()) {
            // throw new NotFoundException("Aranılan kayıt bulunamadı.");
            throw new CategoryNotFoundException("Aranılan kategori bulunamadı.");
        }

        Category category = opetionalCategory.get();
        CategoryDto categoryDto = CategoryMapper.mapCategoryToCategoryDto(category);
        return categoryDto;

    }

    @Override
    public boolean deleteCategoryById(int categoryId) {

        if (existsCategoryById(categoryId)) {
            categoryRepository.deleteById(categoryId);
            return true;
        }
        return false;
    }

    @Override
    public int addCategory(CategoryDto categoryDto) {
        List<Category> categories = categoryRepository.findByName(categoryDto.getName());
        if (categories.size() > 0) {
            logger.error("Kullanici var olan bir kategori eklemeye calisirken zortladi", categoryDto.getName());
            throw new UserBasedException("Var olan kategori tekrar eklenemez.");
        }

        Category category = CategoryMapper.mapCategoryDtoToEntity(categoryDto);
        categoryRepository.save(category);
        return category.getId();
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto) {
        boolean existCategoryById = existsCategoryById(categoryDto.getId());
        if (!existCategoryById) {
            throw new CategoryNotFoundException("İstenilen Kategori bulunamadı.");
        }
        Category entity = CategoryMapper.mapCategoryDtoToEntity(categoryDto);
        categoryRepository.save(entity);

        return CategoryMapper.mapCategoryToCategoryDto(entity);
    }

    @Override
    public List<Category> searchCategoryByName(String categoryName) {
        List<Category> categoryList = categoryRepository.findByNameIgnoreCase(categoryName);
        return categoryList;
    }

    @Override
    public List<Category> searchCategoryByName(String categoryName, int pageNo, int pageSize, Direction sortDirection,
            String sortProperty) {
        PageRequest pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortDirection, sortProperty));
        List<Category> categoryList = categoryRepository.findByName(categoryName, pageable);
        return categoryList;
    }

    @Override
    public boolean existsCategoryById(int categoryId) {
        boolean existsById = categoryRepository.existsById(categoryId);
        return existsById;
    }

}
