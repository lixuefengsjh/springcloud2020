package com.atguigu.springcloud.Service;

import com.atguigu.springcloud.Entity.CommonResult;
import com.atguigu.springcloud.Entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author: lxf
 * @create: 2020-03-13 18:47
 * @description:
 */
@Component
@FeignClient(name = "CLOUD-PAYMENT-SERVICE")
public interface PaymentService {
    @GetMapping("/payment/{id}")
    public CommonResult<Payment> queryPaymentById(@PathVariable("id") Long id);
    @GetMapping("/payment/payment/lb")
    String getPaymentLB();
}
