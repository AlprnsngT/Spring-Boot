package com.btkakademi.login.service;

import java.util.ArrayList;

import com.btkakademi.login.dto.entity.UserInfo;

public interface UserService {

    public int addUser(UserInfo name);

    boolean existsById(int id);

    public ArrayList<UserInfo> getAll();
    
}
