package practice.jpa.board.config.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import practice.jpa.board.entity.Auth;
import practice.jpa.board.entity.Member;
import practice.jpa.board.exceptionBundle.SecurityKeySettingException;
import practice.jpa.board.repository.auth.AuthRepository;

import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TokenSetting implements InitializingBean
{

    public  TokenSetting(
            @Value("${jwt.time.access}")Long accessValidTime,
            @Value("${jwt.time.refresh}")Long refreshValidTime,
            @Value("${jwt.secret}") String secret,
            AuthRepository authRepository
    )
    {
        this.accessValidTime = accessValidTime;
        this.refreshValidTime = refreshValidTime;
        this.secretKey = secret;
        this.authRepository = authRepository;
    }

    private final Long accessValidTime;
    private final Long refreshValidTime;
    private final String secretKey;
    private Key key;
    private final AuthRepository authRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        try {
            byte[] keyBytes = Decoders.BASE64.decode(secretKey);
            this.key = Keys.hmacShaKeyFor(keyBytes);
        }
        catch (SecurityKeySettingException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public String getAccessToken(Authentication authentication)
    {
        String authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));

        Auth auth = authRepository.findByLoginId(authentication.getName())
                .orElseThrow(EntityNotFoundException::new);


        Member member = authRepository.getMemberById(auth.getPid())
                                            .orElseThrow(EntityNotFoundException::new);

        return Jwts.builder().setSubject(authentication.getName())
                .claim("ROLE",authorities)
                .claim("auth_pid",auth.getPid())
                .claim("member_pid",member.getPid())
                .signWith(key, SignatureAlgorithm.HS512)
                .setExpiration(new Date((new Date()).getTime()+accessValidTime))
                .compact();
    }

    public String getRefreshToken()
    {
        return Jwts.builder()
                .setExpiration(new Date((new Date()).getTime()+refreshValidTime))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

}
