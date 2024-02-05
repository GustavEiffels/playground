package practice.jpa.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import practice.jpa.board.enumtype.JwtState;
import practice.jpa.board.exceptionBundle.token.JwtValidCheckException;

@Controller
public class TestController {

    @GetMapping("/mean")
    @ResponseBody
    public String test()
    {
        return "mean";
    }


    @PostMapping("/mean")
    @ResponseBody
    public String test1()
    {
        return "mean";
    }

    @PostMapping("/token-test")
    @ResponseBody
    public String tokenTest()
    {
        throw new JwtValidCheckException(JwtState.INVALID);
    }

}
