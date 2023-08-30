package com.btkakademi.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.btkakademi.login.dto.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>{
    Optional<UserInfo> findByName(String username);
    
}
