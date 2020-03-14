package com.atguigu.springcloud.service;

import com.atguigu.springcloud.Entity.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @author: lxf
 * @create: 2020-03-14 09:52
 * @description:
 */
@Component
public class PaymentHystrixService  implements PaymentService{
    @Override
    public CommonResult<String> paymentOk(int id) {
        return new CommonResult<>(444,"paymentOk ====失败后的降级处理");
    }

    @Override
    public CommonResult<String> paymentFailed(int id) {
        return new CommonResult<>(444,"paymentFailed ====失败后的降级处理");
    }
}
