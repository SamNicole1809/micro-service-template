package cn.sam.micro.usercenter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {

    @GetMapping("/test")
    public String test(@RequestParam("word") String word) {
        return "micro-usercenter say: " + word;
    }

    @GetMapping("/info")
    public String getUserInfo(@RequestParam("userId") String userId) {
        return "username: sam, id: " + userId;
    }

}
