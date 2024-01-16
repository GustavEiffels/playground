package practice.jpa.board.service;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import practice.jpa.board.dto.MemberInfoDto;
import practice.jpa.board.entity.Auth;
import practice.jpa.board.entity.Member;
import practice.jpa.board.entity.RoleAndAuth;
import practice.jpa.board.repository.auth.AuthRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class CreateMemberTest
{
    @Autowired
    CreateUpdateMemberService createUpdateMember;

    @Autowired
    AuthRepository authRepository;

    @Autowired
    EntityManager em;

    Long auth_pid;
    String login_id = "testLoginId01";

    String userName = "김연습";

    @BeforeEach
    void createMember()
    {
        MemberInfoDto memberInfoDto = MemberInfoDto.builder()
                .age(10)
                .city("경기도 성남시")
                .phone("010-1234-5678")
                .loginId(login_id)
                .password("Qwer!234")
                .street("대왕판교로")
                .userEmail("testLoginId01@naver.com")
                .userName(userName)
                .zipcode("12345")
                .build();

        auth_pid = createUpdateMember.createMember(memberInfoDto);
        em.clear();
    }




    @Test
    @DisplayName("Member 와 Auth 를 생성 / em.persist 사용 ")
    void 회원_생성_테스트()
    {
        Auth auth =  authRepository.findById(auth_pid).get();
        RoleAndAuth roleAndAuth = em.createQuery("select raa from RoleAndAuth raa where raa.auth =: auth", RoleAndAuth.class)
                .setParameter("auth",auth)
                        .getResultList().get(0);

        System.out.println(roleAndAuth.getRole());
    }

    @Test
    @DisplayName("login id 로 Auth 객체 찾기 ")
    void 로그인_아이디로_계정_찾기()
    {
        Optional<Auth> findAuthByPid = authRepository.findById(auth_pid);
        Optional<Auth> findAuthByLoginId = authRepository.findByLoginId(login_id);
        assertThat(findAuthByPid.get().getLoginId()).isEqualTo(findAuthByLoginId.get().getLoginId());

        System.out.println("pid 로 찾은 Auth 의 Login Id : "+findAuthByPid.get().getLoginId());
        System.out.println("loginId 로 찾은 Auth 의 Login Id : "+findAuthByLoginId.get().getLoginId());
    }


    @Test
    @DisplayName("Auth pid 로 Member 찾기")
    void auth_pid_로_member_찾기()
    {
        Optional<Member> findMemberByAuthPid = authRepository.getMemberById(auth_pid);
        assertThat(findMemberByAuthPid.get().getUserName()).isEqualTo(userName);
    }




}