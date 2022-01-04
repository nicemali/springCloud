package com.org.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface OrderHystrixService {

    @GetMapping("/payment/hystrix/paymentInfo_OK/{id}")
    public  String paymentInfo(@PathVariable("id") int id);

    @GetMapping("/payment/hystrix/paymentInfo_TimeOut/{id}")
    public  String paymentInfo_TimeOut(@PathVariable("id")int id);
}
