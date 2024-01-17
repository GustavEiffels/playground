package practice.jpa.board.service;

import org.springframework.http.ResponseEntity;
import practice.jpa.board.dto.LoginDto;

public interface LoginService
{
    LoginDto.Response login(LoginDto.Request request);
}
