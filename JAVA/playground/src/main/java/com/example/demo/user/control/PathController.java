package com.example.demo.user.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PathController 
{
    @GetMapping("/joinPage")
    public String forwardToLoginPage()
    {
        return "join/createUser.html";
    }
}
