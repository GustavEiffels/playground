package practice.jpa.board.config.security.detail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import practice.jpa.board.entity.Auth;
import practice.jpa.board.repository.auth.AuthRepository;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@RequiredArgsConstructor
public class SecurityDetail implements UserDetails {

    private final Auth auth;
    private final String roleType;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(()-> roleType);
        return authorities;
    }

    @Override
    public String getPassword() {
        return auth.getPassword();
    }

    @Override
    public String getUsername() {
        return auth.getLoginId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
