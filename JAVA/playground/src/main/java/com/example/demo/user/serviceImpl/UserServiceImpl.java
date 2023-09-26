package com.example.demo.user.serviceImpl;

import org.springframework.stereotype.Service;

import com.example.demo.user.dto.User;
import com.example.demo.user.repository.UserRepository;
import com.example.demo.user.service.UserService;

@Service
public class UserServiceImpl implements UserService
{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository)
    { this.userRepository = userRepository; }

    @Override
    public void saveUserInfo(User user) 
    { userRepository.save(user); }
        
}
