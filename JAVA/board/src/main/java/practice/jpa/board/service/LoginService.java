package practice.jpa.board.service;

import practice.jpa.board.controller.dto.LoginDto;

public interface LoginService
{
    LoginDto.Response login(LoginDto.Request request);
}
