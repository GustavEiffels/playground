package com.example.demo.user.control;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.common.dto.ReturnDto;
import com.example.demo.user.dto.UserCreateDto;
import com.example.demo.user.service.UserService;
import com.google.gson.Gson;

@RestController
public class ServiceController  
{
    private UserService userService;

    public ServiceController(UserService userService) { this.userService = userService; }

    @PostMapping("/createAccount")
    public String createAccount(@RequestBody UserCreateDto userCreateDto)
    {
        System.out.println("CALL createAccount Method ");
        String result = "";
        try 
        {
            userService.saveUserInfo(userCreateDto);

            result = new Gson().toJson(new ReturnDto().success("CREATE SUCCESS", null));

            return result;
        } 
        catch (Exception e) 
        {
            result = new Gson().toJson(new ReturnDto().fail("ERROR EMEREGE : "+e.getMessage(), null));
            return result;
        }
        finally
        {
            System.out.println(result);
        }
    }       

    @PostMapping("/getAllUserInfo")
    public void getAllUserInfo()
    {
        userService.findAllUser();
    }
}
