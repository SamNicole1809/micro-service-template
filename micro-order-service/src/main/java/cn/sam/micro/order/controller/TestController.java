package cn.sam.micro.order.controller;

import cn.sam.micro.feign.api.AuthorizationFeignService;
import cn.sam.micro.feign.api.UserCenterFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping
public class TestController {

    @Autowired
    private UserCenterFeignService userCenterFeignService;
    @Autowired
    private AuthorizationFeignService authorizationFeignService;

    @GetMapping("/test")
    public String test(@RequestParam("word") String word) {
        return "micro-order-service say: " + word;
    }

    @GetMapping("/order/list")
    public String getOrderList(HttpServletRequest request) {
        request.getHeader("token");
        System.out.println("get user id from token such as jwt");
        System.out.println(userCenterFeignService.getUserInfo("user-id"));
        System.out.println(authorizationFeignService.getAuthInfo("user-id"));
        System.out.println("has order:view permission");
        System.out.println("return order list");
        return "order list";
    }

}
