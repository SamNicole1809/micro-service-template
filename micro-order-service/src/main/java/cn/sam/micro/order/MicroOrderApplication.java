package cn.sam.micro.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("cn.sam.micro.feign.api")
public class MicroOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroOrderApplication.class, args);
    }

}
