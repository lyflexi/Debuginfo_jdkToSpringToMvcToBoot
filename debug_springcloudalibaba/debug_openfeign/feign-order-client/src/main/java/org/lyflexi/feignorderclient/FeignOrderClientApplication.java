package org.lyflexi.feignorderclient;

import org.lyflexi.feignorderclient.feign.config.DefaultConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(defaultConfiguration = {DefaultConfiguration.class}) // 开启feign
@EnableDiscoveryClient
public class FeignOrderClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignOrderClientApplication.class, args);
    }

}
