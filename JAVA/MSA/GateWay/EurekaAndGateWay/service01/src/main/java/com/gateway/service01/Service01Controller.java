package com.gateway.service01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service01Controller {

    @GetMapping("/service01/call/out")
    public String callOutService01() {
        return "HI THIS IS SERVICE 1";
    }


}
