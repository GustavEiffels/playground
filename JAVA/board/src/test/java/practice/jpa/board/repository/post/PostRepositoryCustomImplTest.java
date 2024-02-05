package practice.jpa.board.repository.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import practice.jpa.board.controller.dto.MemberInfoDto;
import practice.jpa.board.controller.dto.SearchPostDto;
import practice.jpa.board.controller.dto.SearchPostResultDto;
import practice.jpa.board.entity.Auth;
import practice.jpa.board.entity.Post;
import practice.jpa.board.exceptionBundle.exceptions.NotFoundLoginId;
import practice.jpa.board.repository.auth.AuthRepository;
import practice.jpa.board.service.CreateUpdateMemberService;
import java.util.ArrayList;
import java.util.List;



@SpringBootTest
@Transactional
class PostRepositoryCustomImplTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CreateUpdateMemberService createUpdateMemberService;

    @Autowired
    AuthRepository authRepository;

    @BeforeEach
    void beforeSetting()
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
                .userNick("TEST01")
                .zipcode("12345")
                .build();

        long test01Pid = createUpdateMemberService.createMember(memberInfoDto);


        MemberInfoDto memberInfoDto2 = MemberInfoDto.builder()
                .age(10)
                .city("경기도 성남시")
                .phone("010-1234-5679")
                .loginId("testLoginId02")
                .password("Qwer!234")
                .street("대왕판교로")
                .userEmail("testLoginId02@naver.com")
                .userName("테스트02")
                .userNick("TEST02")
                .zipcode("12345")
                .build();

        long test02Pid = createUpdateMemberService.createMember(memberInfoDto2);

        Auth auth01 = authRepository.findById(test01Pid).orElseThrow(NotFoundLoginId::new);
        Auth auth02 = authRepository.findById(test02Pid).orElseThrow(NotFoundLoginId::new);

        Post post1 = Post.builder()
                .title("abcde")
                .contents("가나다라마")
                .view(0)
                .auth(auth01).build();

        Post post2 = Post.builder()
                .title("stuvw")
                .contents("바사아자")
                .view(100)
                .auth(auth01).build();

        Post post3 = Post.builder()
                .title("kkkkkk")
                .contents("가나다라마")
                .view(20)
                .auth(auth02).build();

        Post post4 = Post.builder()
                .title("kkka")
                .contents("바사아자")
                .view(1200)
                .auth(auth02).build();

        List<Post> postList = new ArrayList<>();
        postList.add(post1);
        postList.add(post2);
        postList.add(post3);
        postList.add(post4);

        postRepository.saveAll(postList);

    }

    @Test
    void find_Post_BY_Search()
    {
        SearchPostDto request = new SearchPostDto();
        request.setAsc(true);

        Page<SearchPostResultDto> searchPost = postRepository.getSearchPost(request, PageRequest.of(0, 4));

        for (SearchPostResultDto searchPostResultDto : searchPost) {

            System.out.println("searchPostResultDto : "+searchPostResultDto.toString() );
        }
    }
}