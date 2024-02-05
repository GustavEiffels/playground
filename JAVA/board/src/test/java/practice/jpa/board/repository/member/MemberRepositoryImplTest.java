package practice.jpa.board.repository.member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import practice.jpa.board.controller.dto.FindMemberDto;
import practice.jpa.board.controller.dto.MemberInfoDto;
import practice.jpa.board.service.CreateUpdateMemberService;


@SpringBootTest
//@Transactional
class MemberRepositoryImplTest {

    @Autowired
    CreateUpdateMemberService createUpdateMemberService;

    @Autowired
    MemberRepository memberRepository;

    @BeforeEach
    @DisplayName("사용자 100 명 만들기")
    void createMember_100()
    {
        for(int i = 0 ; i<=100; i++)
        {
            MemberInfoDto memberInfoDto = MemberInfoDto.builder()
                    .age(i)
                    .city("경기도 "+(i%2 == 0 ? "성남시":"수원시"))
                    .phone("010-1234-5678"+i)
                    .loginId("testLoginId"+i)
                    .password("Qwer!234")
                    .street("대왕판교로"+ (i%2 == 0 ? 1:2))
                    .userEmail("testLoginId"+i+"@naver.com")
                    .userName("테스트"+i)
                    .userNick("test"+i)
                    .zipcode("12345"+i%10)
                    .build();
            createUpdateMemberService.createMember(memberInfoDto);
        }
    }

//    @Test
//    void memberConfirmTest()
//    {
//        List<Member> all = memberRepository.findAll();
//        for (Member member : all) {
//            System.out.println(member.getUserName());
//            System.out.println(member.getAge());
//            System.out.println(member.getAddress().getCity());
//        }
//    }

    @Test
    @DisplayName("청소년 뽑기")
    void getTeenAger()
    {
        FindMemberDto findMemberDto = new FindMemberDto();

        Page<FindMemberDto> conditionMemberList = memberRepository.getConditionMemberList(findMemberDto, PageRequest.of(0,20));

        for (FindMemberDto memberDto : conditionMemberList) {
            System.out.println(memberDto.toString());
        }

    }

}