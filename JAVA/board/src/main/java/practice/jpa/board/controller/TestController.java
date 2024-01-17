package practice.jpa.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
