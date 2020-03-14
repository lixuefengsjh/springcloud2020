package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: lxf
 * @create: 2020-03-13 18:42
 * @description:
 */
@SpringBootApplication
@EnableFeignClients
public class FeignOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrder80.class);
    }
}
