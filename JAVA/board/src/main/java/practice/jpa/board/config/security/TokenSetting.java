package practice.jpa.board.config.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecurityException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import practice.jpa.board.controller.dto.TokenDto;
import practice.jpa.board.entity.Auth;
import practice.jpa.board.entity.Member;
import practice.jpa.board.enumtype.JwtState;
import practice.jpa.board.exceptionBundle.SecurityKeySettingException;
import practice.jpa.board.exceptionBundle.token.JwtValidCheckException;
import practice.jpa.board.repository.auth.AuthRepository;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import static io.jsonwebtoken.Jwts.*;
import static org.springframework.util.StringUtils.hasText;

@Component
public class TokenSetting implements InitializingBean
{

    public  TokenSetting(
            @Value("${jwt.time.access}")Long accessValidTime,
            @Value("${jwt.time.refresh}")Long refreshValidTime,
            @Value("${jwt.secret}") String secretKey,
            AuthRepository authRepository
    )
    {
        this.accessValidTime = accessValidTime;
        this.refreshValidTime = refreshValidTime;
        this.secretKey = secretKey;
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

        return builder().setSubject(authentication.getName())
                .claim("ROLE",authorities)
                .claim("auth_pid",auth.getPid())
                .claim("member_pid",member.getPid())
                .signWith(key, SignatureAlgorithm.HS512)
                .setExpiration(new Date((new Date()).getTime()+accessValidTime))
                .compact();
    }

    public String getRefreshToken()
    {
        return builder()
                .setExpiration(new Date((new Date()).getTime()+refreshValidTime))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    public Authentication getAuthentication(String accessToken)
    {

        Claims claims = tokenValidCheck(accessToken);

        if(!hasText(claims.get("ROLE").toString())) {
            throw new JwtValidCheckException(JwtState.EMPTY_AUTH);
        }

        Collection<? extends GrantedAuthority> authorities = Arrays.stream(claims.get("ROLE").toString().split(","))
                .map(SimpleGrantedAuthority::new).toList();

        UserDetails principal = new User(claims.getSubject(),"",authorities);
        return  new UsernamePasswordAuthenticationToken(principal,"",authorities);
    }


    public Claims tokenValidCheck(String accessToken)
    {
        try {
            return parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();
        }
        catch (SecurityException | MalformedJwtException e){
            throw new JwtValidCheckException(JwtState.INVALID);
        }
        catch (ExpiredJwtException e){
            throw new JwtValidCheckException(JwtState.EXPIRE);
        }
        catch (UnsupportedJwtException e){
            throw new JwtValidCheckException(JwtState.UNSUPPORTED);
        }
        catch (IllegalArgumentException e){
            throw new JwtValidCheckException(JwtState.EMPTY);
        }
    }

}
