package practice.jpa.board.repository.roleAndAuth;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;


public class RoleAndAuthRepositoryImpl implements RoleAndAuthRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public RoleAndAuthRepositoryImpl(EntityManager em)
    {
        queryFactory = new JPAQueryFactory(em);
    }


}
