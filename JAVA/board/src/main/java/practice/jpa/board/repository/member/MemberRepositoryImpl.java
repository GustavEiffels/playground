package practice.jpa.board.repository.member;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

public class MemberRepositoryImpl implements MemberRepositoryCustom
{
    private final JPAQueryFactory queryFactory;

    public MemberRepositoryImpl(EntityManager em)
    {
        queryFactory = new JPAQueryFactory(em);
    }



}
