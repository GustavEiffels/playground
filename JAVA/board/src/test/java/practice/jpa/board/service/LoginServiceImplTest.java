package practice.jpa.board.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import practice.jpa.board.controller.dto.MemberInfoDto;
import practice.jpa.board.exceptionBundle.NotFoundLoginId;

@SpringBootTest
//@Transactional
class LoginServiceImplTest {

    @Autowired
    LoginService loginService;

    @Autowired
    CreateUpdateMemberService createUpdateMemberService;

    @Autowired
    AuthenticationManagerBuilder authenticationManagerBuilder;

    private String login_id = "loginTestId01";
    private String password = "Qwer!234";

    @BeforeEach
    @DisplayName("Member 생성 ")
    void createMember()
    {
        MemberInfoDto memberInfoDto = MemberInfoDto.builder()
                .age(10)
                .city("경기도 성남시")
                .phone("010-1234-5678")
                .loginId(login_id)
                .password(password)
                .street("대왕판교로")
                .userEmail("testLoginId01@naver.com")
                .userName("김연습")
                .zipcode("12345")
                .build();
        createUpdateMemberService.createMember(memberInfoDto);
    }

    @Test
    @DisplayName("UsernamePasswordAuthenticationToken 사용 전 테스트")
    void UsernamePasswordAuthenticationToken_Before_Using_test()
    {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(login_id, password);
        System.out.println("login_id : "+login_id);
        System.out.println("password : "+password);

        try{
            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
            System.out.println("authenticationToken.getPrincipal() : "+authentication.getPrincipal());
            System.out.println("authenticationToken.getCredentials() : "+authentication.getCredentials());
        }
        catch (NotFoundLoginId e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }



    }
}