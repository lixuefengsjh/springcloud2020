package com.atguigu.springcloud;
import com.atguigu.rule.Myrule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author: lxf
 * @create: 2020-03-09 15:31
 * @description:
 */
@SpringBootApplication
@EnableEurekaClient
//RibbonClient为了自定义的负载
@RibbonClient(name="CLOUD-PAYMENT-SERVICE",configuration = Myrule.class )
public class OderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OderMain80.class);
    }
}
