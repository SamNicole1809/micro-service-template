package cn.sam.micro.authorization.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {

    @GetMapping("/test")
    public String test(@RequestParam("word") String word) {
        return "micro-authorization say: " + word;
    }

    @GetMapping("/info")
    public String getAuthInfo(@RequestParam("userId") String userId) {
        System.out.println(userId);
        return "permission: order:view";
    }

}
