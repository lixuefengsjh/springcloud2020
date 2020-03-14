package com.atguigu.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lxf
 * @create: 2020-03-13 17:24
 * @description: 设置负载均衡策略
 */
@Configuration
public class Myrule {
    @Bean
    public IRule getRule(){
        return  new RandomRule();
    }
}
