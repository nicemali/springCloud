package com.org.controller;


import com.org.entities.CommonResult;
import com.org.service.OrderFeginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private OrderFeginService orderFeginService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult get (@PathVariable("id") String id){
        return orderFeginService.get(id);
    }

    @GetMapping("/consumer/payment/getTimeout")
    public String  getTimeout(){
        return orderFeginService.getTimeout();
    }
}
