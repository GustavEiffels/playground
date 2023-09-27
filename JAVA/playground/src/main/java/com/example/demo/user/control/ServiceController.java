package com.example.demo.user.control;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.dto.UserCreateDto;
import com.example.demo.user.service.UserService;

@RestController
public class ServiceController 
{
    private UserService userService;

    public ServiceController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/createAccount")
    public String createAccount(@RequestBody UserCreateDto userCreateDto)
    {
        
        try 
        {
            userService.saveUserInfo(userCreateDto);
            return "DONE";
        } catch (Exception e) {
            return e.getMessage();
        }
    }       
}
