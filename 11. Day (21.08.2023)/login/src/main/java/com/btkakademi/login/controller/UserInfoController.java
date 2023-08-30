package com.btkakademi.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.btkakademi.login.dto.entity.UserInfo;
import com.btkakademi.login.service.UserService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/user")
public class UserInfoController {

    @Autowired
    UserService userService;

    @PostMapping("/add") // You need to specify the actual path without quotes
    public ResponseEntity<Integer> addUser(@RequestBody UserInfo user) {
        // TODO: process POST request
        return ResponseEntity.ok(userService.addUser(user));
    }

    @GetMapping(value="/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getMethodName() {
        return "Başarılı";
        //return userService.getAll();
    }
    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String getById(@PathVariable int id) {
        return "kullancı bulunamadı";
    }
    
    
}
