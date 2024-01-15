package practice.jpa.board.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.jpa.board.entity.Member;

public interface MemberRepository extends JpaRepository<Member,Long>
{
}
