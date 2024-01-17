package practice.jpa.board.common.config.security.detail;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import practice.jpa.board.entity.Auth;
import practice.jpa.board.entity.Role;
import practice.jpa.board.exceptionBundle.NotFoundLoginId;
import practice.jpa.board.exceptionBundle.NotFoundUserRoleException;
import practice.jpa.board.repository.auth.AuthRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SecurityDetailService implements UserDetailsService {

    private final AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("loadUserByUsername");
        Auth auth = authRepository.findByLoginId(username)
                .orElseThrow(()-> new NotFoundLoginId("NOT FOUND USER"));

        List<Role> roleList = authRepository.findRole(auth.getPid()).orElseThrow(
                ()->new NotFoundUserRoleException("NOT FOUND ANY USER ROLE INFO"));

        return new SecurityDetail(auth,roleList);

    }
}
