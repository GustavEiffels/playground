package practice.jpa.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.jpa.board.dto.JoinDto;
import practice.jpa.board.entity.Member;
import practice.jpa.board.entity.embedded.Address;
import practice.jpa.board.repository.member.MemberRepository;

@Service
@RequiredArgsConstructor
public class CreateMember {

    private final MemberRepository memberRepository;

    void createMember(JoinDto joinDto)
    {
        Member member = Member.builder()
                .age(joinDto.getAge())
                .userName(joinDto.getUserName())
                .phone(joinDto.getPhone())
                .userEmail(joinDto.getUserEmail())
                .address(new Address(joinDto.getCity(), joinDto.getStreet(), joinDto.getZipcode()))
                .build();


    }

}
