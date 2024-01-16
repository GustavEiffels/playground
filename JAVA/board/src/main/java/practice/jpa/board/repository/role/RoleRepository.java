package practice.jpa.board.repository.role;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.jpa.board.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Long>,RoleRepositoryCustom {
}
