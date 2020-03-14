package com.atguigu.springcloud.service;

import com.atguigu.springcloud.Entity.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: lxf
 * @create: 2020-03-13 22:37
 * @description:
 */
@Component
@FeignClient(name = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentHystrixService.class)
public interface PaymentService {
    @GetMapping("/ok/{id}")
    public CommonResult<String> paymentOk(@PathVariable("id") int id );

    @GetMapping("/failed/{id}")
    public CommonResult<String> paymentFailed(@PathVariable("id") int id);
}
