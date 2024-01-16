package practice.jpa.board.repository.role;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;
import practice.jpa.board.entity.Role;

public class RoleRepositoryImpl implements RoleRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public RoleRepositoryImpl(EntityManager em)
    {
        queryFactory = new JPAQueryFactory(em);
    }

    @Transactional
    @Override
    public Role findRole() {
        return null;
    }
}
