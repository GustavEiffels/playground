package practice.jpa.board.repository.auth;

import practice.jpa.board.entity.Auth;
import practice.jpa.board.entity.Member;
import practice.jpa.board.entity.Role;
import practice.jpa.board.enumtype.RoleType;

import java.util.List;
import java.util.Optional;

public interface AuthRepositoryCustom {

    Optional<List<Role>> findRole(Long auth_pid);

    Optional<Auth> findByLoginId(String loginId);

    Optional<Member> getMemberById(Long auth_pid);
}
