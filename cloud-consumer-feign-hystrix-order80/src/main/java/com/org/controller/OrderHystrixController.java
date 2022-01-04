package com.org.controller;

import com.org.service.OrderHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderHystrixController {

    @Resource
    private OrderHystrixService orderHystrixService;

    @GetMapping("/consumer/hystrix/paymentInfo_OK/{id}")
    public  String paymentInfo_OK(@PathVariable("id") int id){
        return  orderHystrixService.paymentInfo(id);
    }

    @GetMapping("/consumer/hystrix/paymentInfo_TimeOut/{id}")
    public  String paymentInfo_TimeOut(@PathVariable("id")int id){
        return orderHystrixService.paymentInfo_TimeOut(id);
    }
}
