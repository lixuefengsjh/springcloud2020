package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.Entity.CommonResult;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lxf
 * @create: 2020-03-13 22:39
 * @description:
 */
@RestController
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class HystrixContrller {
    @Autowired
    private PaymentService paymentService;
    @GetMapping("/consumer/ok/{id}")
    public CommonResult<String> paymentOk(@PathVariable("id") int id ){
        return paymentService.paymentOk(id);
    };
    @GetMapping("/consumer/failed/{id}")
//   @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
//    })
    @HystrixCommand
    public CommonResult<String> paymentFailed(@PathVariable("id") int id){
        return paymentService.paymentFailed(id);
    };
    public CommonResult<String> paymentTimeOutFallbackMethod(@PathVariable("id") int id) {
        return new CommonResult(444,"","你妈的");
    }
    //下面是全局fallback方法
    public CommonResult<String>  payment_Global_FallbackMethod(){
        return  new CommonResult(444,"","Global异常处理信息，请稍后再试,/(ㄒoㄒ)/~~");
    }

}
