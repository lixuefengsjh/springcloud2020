package com.atguigu.springcloud.Controller;
import com.atguigu.springcloud.Entity.CommonResult;
import com.atguigu.springcloud.Entity.Payment;
import com.atguigu.springcloud.Service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: lxf
 * @create: 2020-03-09 10:30
 * @description:
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Value("${server.port}")
    private String port;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private DiscoveryClient discoveryClient;
    @GetMapping("/{id}")
   public CommonResult<Payment> queryPaymentById(@PathVariable Long id){
        Payment payment= paymentService.queryPaymentById(id);
        log.info("测试数据8001");
        if(payment!=null){
            return new CommonResult(200,"查询成功,数据来源于端口："+port,payment);
        }else{
            return new CommonResult(400,"未查询到对应的数据"+port,null);
        }
    }
    @GetMapping
    public CommonResult<List<Payment>> queryPaymentAll(){
        List<Payment> lists= paymentService.queryPaymentAll();
        if(lists!=null&&lists.size()>0){
            return new CommonResult(200,"查询成功",lists);
        }else{
            return new CommonResult(400,"未查询到对应的数据",null);
        }
    }
    @PostMapping
    public CommonResult insertPayment( @RequestBody  Payment payment){
        paymentService.insertPayment(payment);
        return  new CommonResult(200,"插入成功");
    }
    @PutMapping
    public CommonResult updatePayment(@RequestBody Payment payment){
        paymentService.updatePayment(payment);
        return new CommonResult(200,"修改数据成功");
    }

    @DeleteMapping
    public CommonResult deletePayment(@RequestBody  List<Long> ids ){
        paymentService.deletePayment(ids);
        return new CommonResult(200,"删除数据成功");
    }
    @GetMapping("/discovery")
    public CommonResult<DiscoveryClient> get(){
      List<String> services= discoveryClient.getServices();
        for (int i = 0; i < services.size(); i++) {
            log.info(services.get(i));
        }
      List<ServiceInstance> instances= discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return new CommonResult(200,"查询成功",discoveryClient);
    }
    /**
     * 自定义负载均衡算法测试接口
     * @return
     */
    @GetMapping(value ="/payment/lb")
    public String getPaymentLB() throws InterruptedException {

        TimeUnit.SECONDS.sleep(3);
        return port;
    }
}
