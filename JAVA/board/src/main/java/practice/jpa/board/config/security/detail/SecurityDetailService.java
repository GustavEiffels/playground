package practice.jpa.board.config.security.detail;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import practice.jpa.board.entity.Auth;
import practice.jpa.board.repository.auth.AuthRepository;


@Service
@RequiredArgsConstructor
public class SecurityDetailService implements UserDetailsService {

    private final AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Auth auth = authRepository.findByLoginId(username)
                .orElseThrow(()-> new UsernameNotFoundException("NOT FOUND USER"));

        String roleType = authRepository.findRole(auth.getPid()).get(0).getType().name();

        return new SecurityDetail(auth,roleType);

    }
}
