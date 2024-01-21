package practice.jpa.board.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.jpa.board.entity.Auth;

public interface AuthRepository extends JpaRepository<Auth,Long> , AuthRepositoryCustom{


}
