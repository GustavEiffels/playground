package com.example.demo.user.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PathController 
{
    @GetMapping("/joinPage")
    public String forwardToLoginPage()
    {
        System.out.println("requested from js"); 
        return "join/createUser.html";
    }
}
