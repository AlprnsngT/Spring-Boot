package com.example.demo.util.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;

import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.entity.Category;

public class CategoryMapper {

    public static CategoryDto mapCategoryToCategoryDto(Category category){
        DozerBeanMapper mapper = new DozerBeanMapper();
        CategoryDto categoryDto = mapper.map( category, CategoryDto.class);
        return categoryDto;
    }

    public static List<CategoryDto> mapCategoryListToCategoryDtoList(List<Category> categoryList){
        List<CategoryDto> returnList = new ArrayList<CategoryDto>(); 
        for (Category category : categoryList) {
            CategoryDto categoryDto = mapCategoryToCategoryDto(category);
            returnList.add(categoryDto);
        }
        return returnList;
    }
}
