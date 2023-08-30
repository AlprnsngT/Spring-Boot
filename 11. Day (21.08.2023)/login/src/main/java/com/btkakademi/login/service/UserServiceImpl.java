package com.btkakademi.login.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btkakademi.login.dto.entity.UserInfo;
import com.btkakademi.login.repository.UserInfoRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserInfoRepository repository;

    @Override
    public int addUser(UserInfo user) {
        
        if(!existsById(user.getId())){
             repository.save(user);
        return user.getId();
        }
        return 0;

    }

    @Override
    public boolean existsById(int id) {
        boolean existsById = repository.existsById(id);
        return existsById;
    }

    @Override
    public ArrayList<UserInfo> getAll() {
        return new ArrayList<UserInfo>(getAll());
    }

}
