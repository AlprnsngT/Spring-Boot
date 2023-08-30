package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {

        List<Category> categoryList = categoryRepository.findAll();
        return categoryList;
    }

    @Override
    public boolean deleteCategoryById(int categoryId) {

        // veri var mı yok mu bunu daha basit bir şekilde kullanarak çözebiliriz.
        //boolean existsById = categoryRepository.existsById(categoryId);
        /*
         * optinal paramtresi gün sonunda null dönebilecek bir değer varsa
         * nullPointerException hatası almamak için kullanılır
         * findById ile veri tabanında o veri var mı yok mu önce kontrol etmek gerekir .
         */

        // existsById sayesinde bu fonksiyona ihtiyaç kalmıyor.
        /*
         * Optional<Category> optionalCategory = categoryRepository.findById(1);
         * if (optionalCategory.isPresent()) {
         * Category category = optionalCategory.get();
         * categoryRepository.delete(category);
         * return true;
         * }
         */
        
        if (existsCategoryById(categoryId)) {
            categoryRepository.deleteById(categoryId);
            return true;
        }
        return false;
    }

    @Override
    public Category getCategoryById(int category_Id) {
        Optional<Category> optionalCategory = categoryRepository.findById(category_Id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            return category;
        }
        return null;
    }

    @Override
    public int addCategory(Category category) {
        if (existsCategoryById(category.getId())){
            categoryRepository.save(category);
            return category.getId();
        }
        return 0;
    }

    @Override
    public Category updateCategory(Category category) {
        if(existsCategoryById(category.getId())){
            ((Category) categoryRepository).setId(category.getId());
            ((Category) categoryRepository).setName(category.getName());
            return categoryRepository.save(category);
        }
        return category;
    }

    @Override
    public List<Category> searchCategoryByName(String categoryName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchCategoryByName'");
    }

    @Override
    public boolean existsCategoryById(int categoryId) {
        boolean existsById = categoryRepository.existsById(categoryId);
        return existsById; // bu parametre zaten geri dönüş olarak boolean döner.
    }

}
