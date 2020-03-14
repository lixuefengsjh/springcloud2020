package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.Entity.CommonResult;
import com.atguigu.springcloud.service.PaymenntService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lxf
 * @create: 2020-03-13 22:13
 * @description:
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymenntService paymenntService;
    @GetMapping("/ok/{id}")
    public CommonResult<String> paymentOk(@PathVariable("id") int id ){
        return  new CommonResult(200,"",paymenntService.paymentOk(id));
    }

    @GetMapping("/failed/{id}")
    public CommonResult<String> paymentFailed(@PathVariable("id") int id){
        return  new CommonResult(200,"",paymenntService.paymentFailed(id));
    }
    /**
     * 服务熔断
     * http://localhost:8001/payment/circuit/32
     * @param id
     * @return
     */
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymenntService.paymentCircuitBreaker(id);
        log.info("***result:" + result);
        return result;
    }
}
