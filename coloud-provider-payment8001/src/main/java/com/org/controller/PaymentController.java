package com.org.controller;


import com.org.dao.PaymentDao;
import com.org.entities.CommonResult;
import com.org.entities.Payment;
import com.org.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/payment/get/{serial}")
    public CommonResult get(@PathVariable("serial") String serial){
        Payment payment = paymentService.get(serial);
        if(payment != null){
            log.info("查询结果是："+payment+";端口是：+"+serverPort);
            return new CommonResult("200","success port " + serverPort,payment);
        }else{
            return new CommonResult("0","failed");
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> elements = discoveryClient.getServices();
        for(String element : elements){
            log.info("*********** 服务："+element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for( ServiceInstance instance : instances){
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri() + "\t"+ instance.getMetadata());
        }

        return discoveryClient;
    }

    @GetMapping("/payment/getPortLB")
    public String  getPoetLB(){
        return serverPort;
    }

    @GetMapping("/payment/getTimeout")
    public String  getTimeout(){
        try { TimeUnit.SECONDS.sleep(3); }catch (Exception e) {e.printStackTrace();}
        return serverPort;
    }

}
