package com.atguigu.springcloud.Controller;

import com.atguigu.springcloud.Entity.CommonResult;
import com.atguigu.springcloud.Entity.Payment;
import com.atguigu.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author: lxf
 * @create: 2020-03-09 15:58
 * @description:
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
   // private  static final  String URL="http://localhost:8001/payment";
    private  static final  String URL="http://cloud-payment-service/payment";
    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;
    @GetMapping("/consumer/{id}")
    public CommonResult<Payment> findById(@PathVariable Long id){
       return restTemplate.getForObject(URL+"/"+id,CommonResult.class);
    }
    //测试使用restEntity的使用方法
    @GetMapping("/consumer/entity/{id}")
    public CommonResult<Payment> findByIdEntity(@PathVariable Long id){
        ResponseEntity<CommonResult> entity= restTemplate.getForEntity(URL+"/"+id,CommonResult.class);
        log.info("entity:"+entity);

    if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return  new CommonResult(444,"未查询到合适的信息");
        }

    }
    @GetMapping("/consumer")
    public CommonResult<List<Payment>> findAll(){
        return restTemplate.getForObject(URL,CommonResult.class);
    }
    @GetMapping("/consumer/payment")
    public CommonResult insert(Payment payment){
        return restTemplate.postForObject(URL,payment,CommonResult.class);
    }

    /**
     * 在这边我为了以上程序的正常执行：把自定义接口注释掉，不用自定义负载均衡算法，若想再次启动
     * 请操作一下步骤：
     *          1.注释掉@LoadBalanced（在config下面），放开下方注释，同时会导致上方不可用，因为找不到具体服务
     */

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances ==null || instances.size()<=0){
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/payment/lb",String.class);
    }
}
