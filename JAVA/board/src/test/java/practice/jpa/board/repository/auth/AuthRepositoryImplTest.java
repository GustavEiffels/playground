package practice.jpa.board.repository.auth;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import practice.jpa.board.controller.dto.MemberInfoDto;
import practice.jpa.board.service.CreateUpdateMemberService;

@SpringBootTest
@Transactional
class AuthRepositoryImplTest {

    @Autowired
    AuthRepositoryImpl authRepository;

    @Autowired
    CreateUpdateMemberService createUpdateMemberService;

    @Autowired
    EntityManager em;


    @Test
    @DisplayName("auth pid 로 role 찾기")
    void findRoleByAuthPid()
    {
        MemberInfoDto memberInfoDto = MemberInfoDto.builder()
                .age(10)
                .city("경기도 성남시")
                .phone("010-1234-5678")
                .loginId("testLoginId01")
                .password("Qwer!234")
                .street("대왕판교로")
                .userEmail("testLoginId01@naver.com")
                .userName("테스트01")
                .zipcode("12345")
                .build();

        Long auth_pid     = createUpdateMemberService.createMember(memberInfoDto);


    }
}