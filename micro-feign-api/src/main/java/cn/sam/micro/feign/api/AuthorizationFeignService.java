package cn.sam.micro.feign.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "micro-authorization")
public interface AuthorizationFeignService {

    @GetMapping("/info")
    String getAuthInfo(@RequestParam("userId") String userId);

}
