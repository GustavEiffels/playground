package com.example.demo.user.serviceImpl;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.example.demo.user.repository.UserRepository;
import com.example.demo.user.service.UserValidService;

@Service
public class UserValidServiceImpl implements UserValidService 
{
    private UserRepository userRepository;

    public UserValidServiceImpl(UserRepository userRepository)
    { this.userRepository = userRepository; }


    @Override
    public int validCheckAgeData(String userCreateDtoAge) 
    {
        try                 { return Integer.valueOf(userCreateDtoAge); }
        catch (Exception e) { throw new RuntimeException("사용자 나이 설정 오류 : 타입 확인 필요"); }
    }

    @Override
    public String validCheckIdData(String userCreateDtoId)
    {
        if( Pattern.compile("^[a-z0-9]{4,20}$").matcher(notDuplicateUserId(userCreateDtoId)).matches() )
        { return userCreateDtoId; }

        else
        { throw new RuntimeException("사용자 아이디 설정 오류 : 타입 확인 필요"); }
    }

    @Override
    public String validCheckNamData(String userCreateDtoName) 
    {
        // "^[가-힣\\s]+$";
        if( Pattern.compile( "^[가-힣\\s]+$").matcher(userCreateDtoName).matches() )
        { return userCreateDtoName; }

        else
        { throw new RuntimeException("사용자 이름 설정 오류 : 타입 확인 필요"); }

    }

    @Override
    public boolean validCheckGenderData(String userCerateDtoGender) 
    {
        if( userCerateDtoGender.equals("male") )
        { return true; }
        
        else if( userCerateDtoGender.equals("female") )
        { return false; }

        else
         { throw new RuntimeException("사용자 성별 설정 오류 : 타입 확인 필요"); }

    }

    @Override
    public String notDuplicateUserId(String userCreateDtoId) 
    {
        if(userRepository.findAllUserById(userCreateDtoId).size() > 0 )
        { throw new RuntimeException("ID : "+userCreateDtoId +" is already exist! "); }

        else
        { return userCreateDtoId; }
    }
}
