package com.org.controller;

import com.org.entities.CommonResult;
import com.org.entities.Payment;
import com.org.lb.ILoaderBlance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

//    private  static final  String PAYMENT_URL="http://localhost:8001";
      private  static final  String PAYMENT_URL="http://cloud-payment-service";
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private ILoaderBlance loaderBlance;


    @GetMapping("/consumer/get/{serial}")
    public CommonResult<Payment> get(@PathVariable("serial") String serial){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+serial,CommonResult.class);
    }

    @GetMapping("/consumer/getPaymentLB")
    public  String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size() <= 0){
            return null;
        }

        ServiceInstance serviceInstance = loaderBlance.instance(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/getPortLB",String.class);
    }
}
