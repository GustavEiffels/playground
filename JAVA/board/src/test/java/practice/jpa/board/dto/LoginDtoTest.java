package practice.jpa.board.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoginDtoTest
{
    @Test
    void 로그인DTO_생성_TEST()
    {
        LoginDto.Request request = LoginDto.Request.builder()
                .loginId("testLoginId")
                .password("testLoginPassword")
                .build();

        LoginDto.Response response = LoginDto.Response.builder()
                .accessToken("accessToken")
                .refreshToken("refreshToken")
                .isSuccess(true)
                .message("message")
                .build();
    }

}