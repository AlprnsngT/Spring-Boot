package com.btkakademi.login.service;

import com.btkakademi.login.config.UserInfoUserDetails;
import com.btkakademi.login.dto.entity.UserInfo;
import com.btkakademi.login.repository.UserInfoRepository;

import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepository repository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = repository.findByName(username); // user bilgilerini aldık
        return userInfo.map(UserInfoUserDetails::new) // spring securitynin tanıaycağı UserInfoUserDetailse dönüştürdük map ile
                .orElseThrow(() -> new UsernameNotFoundException("user not found: " + username));
                // -> if else gibi bir şey eğer kullanıcı varsa oluştur yoksa notFoundException fırlat diyoruz.
    }
}
