package practice.jpa.board.service;


import practice.jpa.board.controller.dto.MemberInfoDto;

public interface CreateUpdateMemberService {


    Long createMember(MemberInfoDto memberInfoDto);


}
