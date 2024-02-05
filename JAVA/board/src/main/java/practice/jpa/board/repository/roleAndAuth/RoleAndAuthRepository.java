package practice.jpa.board.repository.roleAndAuth;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.jpa.board.entity.RoleAndAuth;

public interface RoleAndAuthRepository extends JpaRepository<RoleAndAuth, Long>,RoleAndAuthRepositoryCustom {
}
