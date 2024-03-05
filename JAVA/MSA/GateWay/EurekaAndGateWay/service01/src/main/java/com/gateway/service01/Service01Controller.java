package com.gateway.service01;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service01Controller {

    @PostMapping("/service01/call/out")
    public String callOutService01() {
        return "HI THIS IS SERVICE 1";
    }
}
