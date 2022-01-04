package com.org.controller;

import com.org.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/hystrix/paymentInfo_OK/{id}")
    public  String paymentInfo_OK(@PathVariable("id") int id){
       return paymentService.paymentInfo_OK(id);
    }

    @GetMapping("/payment/hystrix/paymentInfo_TimeOut/{id}")
    public  String paymentInfo_TimeOut(@PathVariable("id")int id){
       return paymentService.paymentInfo_TimeOut(id);
    }

}
