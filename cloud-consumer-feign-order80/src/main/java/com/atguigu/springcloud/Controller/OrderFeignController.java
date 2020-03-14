package com.atguigu.springcloud.Controller;

import com.atguigu.springcloud.Entity.CommonResult;
import com.atguigu.springcloud.Entity.Payment;
import com.atguigu.springcloud.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: lxf
 * @create: 2020-03-13 19:04
 * @description:
 */
@RestController
public class OrderFeignController {
    @Resource
    private PaymentService paymentService;
    @GetMapping("/consumer/{id}")
    public CommonResult<Payment> findById(@PathVariable Long id){
        return paymentService.queryPaymentById(id);
    }
    @GetMapping(value ="/consumer/payment/lb")
    public  CommonResult<String> getPaymentLB() {
        return  new CommonResult<>(200,"paymentService.getPaymentLB()",paymentService.getPaymentLB()) ;
    }
}
