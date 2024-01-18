package practice.jpa.board.repository.member;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import practice.jpa.board.controller.dto.FindMemberDto;

public interface MemberRepositoryCustom {

   Page<FindMemberDto> getConditionMemberList(FindMemberDto findMemberDto, Pageable pageable);
}
