package practice.jpa.board.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import practice.jpa.board.controller.dto.LoginDto;
import practice.jpa.board.service.LoginService;


/**
 * 회원과 연관된 controller
 */
@RestController
@RequiredArgsConstructor
public class MemberController
{
    private final LoginService loginService;


    @Operation(summary = "회원 로그인 요청",description = "로그인 요청 성공 시 AccessToken, RefreshToken 를 반환 합니다",tags = "MemberController")
    @PostMapping("/login")
    public ResponseEntity<LoginDto.Response> login(@RequestBody LoginDto.Request request)
    {
        return new ResponseEntity<>(loginService.login(request), HttpStatus.OK);
    }
}
