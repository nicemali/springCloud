package com.org.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public  String paymentInfo_OK(int id){
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_OK,id=" + id+"哈哈！！";
    }


    public  String paymentInfo_TimeOut(int id){
        int timeout = 3;
        try { TimeUnit.SECONDS.sleep(timeout); }catch (Exception e) {e.printStackTrace();}
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_TimeOut,id=" + id+" 耗时(秒):"+timeout;
    }
}
