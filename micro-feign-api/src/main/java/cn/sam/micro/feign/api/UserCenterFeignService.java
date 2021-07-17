package cn.sam.micro.feign.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "micro-usercenter")
public interface UserCenterFeignService {

    @GetMapping("/info")
    String getUserInfo(@RequestParam("userId") String userId);

}
