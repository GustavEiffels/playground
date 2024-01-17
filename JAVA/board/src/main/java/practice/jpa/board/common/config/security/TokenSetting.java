package practice.jpa.board.common.config.security;

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
import practice.jpa.board.dto.TokenDto;
import practice.jpa.board.entity.Auth;
import practice.jpa.board.entity.Member;
import practice.jpa.board.enumtype.JwtState;
import practice.jpa.board.exceptionBundle.SecurityKeySettingException;
import practice.jpa.board.repository.auth.AuthRepository;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import static io.jsonwebtoken.Jwts.*;

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

    public TokenDto.GetAuthenticationResult getAuthentication(String accessToken)
    {
        TokenDto.ValidCheckResult validResult = isTokenValid(accessToken);

        if(validResult.getIsAvailable())
        {
            Claims claims = validResult.getClaims();

            Collection<? extends GrantedAuthority> authorities = Arrays.stream(claims.get("ROLE").toString().split(","))
                    .map(SimpleGrantedAuthority::new).toList();

            UserDetails principal = new User(claims.getSubject(),"",authorities);
            return  new TokenDto.GetAuthenticationResult().SUCCESS(new UsernamePasswordAuthenticationToken(principal,"",authorities));
        }
        return new TokenDto.GetAuthenticationResult().FAIL(false,validResult);
    }

    public TokenDto.ValidCheckResult isTokenValid(String accessToken)
    {
        try
        {
            return new TokenDto.ValidCheckResult(parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody());
        }
        catch (SecurityException | MalformedJwtException e){
            return  new TokenDto.ValidCheckResult(JwtState.INVALID,e);
        }
        catch (ExpiredJwtException e){
            return  new TokenDto.ValidCheckResult(JwtState.EXPIRE,e);
        }
        catch (UnsupportedJwtException e){
            return  new TokenDto.ValidCheckResult(JwtState.UNSUPPORTED,e);
        }
        catch (IllegalArgumentException e){
            return  new TokenDto.ValidCheckResult(JwtState.EMPTY,e);
        }
    }


}
