package com.example.demo.user.service;

import com.example.demo.user.dto.UserCreateDto;

public interface UserService 
{
    void saveUserInfo(UserCreateDto  userCreateDto);
    
    void findAllUser();
}
