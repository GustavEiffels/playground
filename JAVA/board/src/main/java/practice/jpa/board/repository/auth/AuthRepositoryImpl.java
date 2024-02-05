package practice.jpa.board.repository.auth;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import practice.jpa.board.entity.Auth;
import practice.jpa.board.entity.Member;
import practice.jpa.board.entity.QMember;
import practice.jpa.board.entity.Role;
import practice.jpa.board.enumtype.RoleType;
import java.util.List;
import java.util.Optional;

import static practice.jpa.board.entity.QAuth.auth;
import static practice.jpa.board.entity.QMember.member;
import static practice.jpa.board.entity.QRole.role;
import static practice.jpa.board.entity.QRoleAndAuth.roleAndAuth;

public class AuthRepositoryImpl implements AuthRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public AuthRepositoryImpl(EntityManager em)
    {
        queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Optional<List<Role>> findRole(Long auth_pid) {

        return Optional.ofNullable(queryFactory
                .select(role)
                .from(auth)
                .where(auth.pid.eq(auth_pid))
                .leftJoin(auth.roleAndAuths, roleAndAuth)
                .leftJoin(roleAndAuth.role, role)
                .fetch());
    }

    @Override
    public Optional<Auth> findByLoginId(String loginId)
    {
        return Optional.ofNullable(queryFactory
                .selectFrom(auth)
                .where(auth.loginId.eq(loginId)).fetchOne());
    }

    @Override
    public Optional<Member> getMemberById(Long auth_pid) {
        return Optional.ofNullable(
                queryFactory.select(member)
                        .from(auth)
                        .where(auth.pid.eq(auth_pid))
                        .leftJoin(auth.member,member)
                        .fetchOne());
    }
}
