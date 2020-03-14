package com.atguigu.springcloud.Configure;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: lxf
 * @create: 2020-03-09 15:57
 * @description:
 */
@Configuration
public class RestTempleteConfig {
    @Bean
   // @LoadBalanced
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
}
