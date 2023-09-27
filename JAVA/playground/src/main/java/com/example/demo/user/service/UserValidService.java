package com.example.demo.user.service;

public interface UserValidService 
{
    int      validCheckAgeData   (String userCreateDtoAge    );
    String   validCheckIdData    (String userCreateDtoId     );
    String   validCheckNamData   (String userCreateDtoName   );
    boolean  validCheckGenderData(String userCerateDtoGender );
}
