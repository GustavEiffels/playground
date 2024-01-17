package practice.jpa.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import practice.jpa.board.common.config.security.TokenSetting;
import practice.jpa.board.dto.LoginDto;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenSetting tokenSetting;

    @Override
    public LoginDto.Response login(LoginDto.Request request)
    {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(request.getLoginId(), request.getPassword());

        try{
            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
            return LoginDto.Response.builder()
                    .refreshToken(tokenSetting.getAccessToken(authentication))
                    .accessToken(tokenSetting.getRefreshToken())
                    .build();
        }
        catch (AuthenticationException e)
        {
            return LoginDto.Response.builder()
                    .isSuccess(false)
                    .message(e.getMessage())
                    .build();
        }


    }
}
