package practice.jpa.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.jpa.board.controller.dto.FindMemberDto;
import practice.jpa.board.repository.member.MemberRepository;

@RestController
@RequiredArgsConstructor
public class TestRestController
{
    private  final MemberRepository memberRepository;

    @GetMapping("/userInfo")
    public Page<FindMemberDto> searchMember(FindMemberDto dto, Pageable pageable)
    {
        return  memberRepository.getConditionMemberList(dto,pageable);
    }

}
