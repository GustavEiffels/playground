package practice.jpa.board.controller;

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

    @PostMapping("/login")
    public ResponseEntity<LoginDto.Response> login(@RequestBody LoginDto.Request request)
    {
        return new ResponseEntity<>(loginService.login(request), HttpStatus.OK);
    }
}
