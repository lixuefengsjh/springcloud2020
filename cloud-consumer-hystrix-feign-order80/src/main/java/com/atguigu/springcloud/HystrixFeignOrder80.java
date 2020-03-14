package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: lxf
 * @create: 2020-03-13 22:33
 * @description:
 */
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class HystrixFeignOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixFeignOrder80.class);
    }
}
