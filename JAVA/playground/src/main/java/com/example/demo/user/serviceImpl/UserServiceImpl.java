package com.example.demo.user.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.common.dto.Rank;
import com.example.demo.user.dto.User;
import com.example.demo.user.dto.UserCreateDto;
import com.example.demo.user.repository.UserRepository;
import com.example.demo.user.service.UserService;
import com.example.demo.user.service.UserValidService;

@Service
public class UserServiceImpl implements UserService
{

    private UserRepository   userRepository;
    private UserValidService userValidService;

    public UserServiceImpl(UserRepository userRepository, UserValidService userValidService)
    { 
        this.userRepository     = userRepository;
        this.userValidService   = userValidService; 
    }

    @Override
    public void saveUserInfo(UserCreateDto userCreateDto) 
    { 
        try {
            userRepository.save(convert2User(userCreateDto));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public User convert2User(UserCreateDto userCreateDto)
    {
        User user = new User();
        try 
        {
            user.setAge     (userValidService.validCheckAgeData   (userCreateDto.getAge())    );
            user.setGender  (userValidService.validCheckGenderData(userCreateDto.getGender()) );
            user.setId      (userValidService.validCheckIdData    (userCreateDto.getId())     );
            user.setName    (userValidService.validCheckNamData   (userCreateDto.getName())   );
            user.setUserRank( Rank.USER                                                       );
            return user;    
        } 
        catch (Exception e) 
        {
            throw new RuntimeException(e.getMessage());
        }
        
    }

    @Override
    public void findAllUser() 
    {
        List<User> userList = userRepository.findAll();
        for (User user : userList ) 
        {
            System.out.println(user.getAge());  
            System.out.println(user.toString());
        }
    }
        
}
