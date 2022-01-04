package com.org.service;

import com.org.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface OrderFeginService {

    @GetMapping("/payment/get/{id}")
    public CommonResult get (@PathVariable("id") String id);

    @GetMapping("/payment/getTimeout")
    public String  getTimeout();

}
