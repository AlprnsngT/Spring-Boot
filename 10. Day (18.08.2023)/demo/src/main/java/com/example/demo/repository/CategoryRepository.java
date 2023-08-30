package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>{

    @Query("select c from Category c")
    List<Category> getAllCats();

    @Query(nativeQuery = true,value="select * from kategoriler")
    List<Category> getAllCatsNative();

    List<Category> findByName(String name);
    List<Category> findByNameIgnoreCase(String name);
    List<Category> findByName(String name, Pageable pageable);
}
