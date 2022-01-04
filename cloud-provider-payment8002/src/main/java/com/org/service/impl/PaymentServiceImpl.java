package com.org.service.impl;

import com.org.dao.PaymentDao;
import com.org.entities.Payment;
import com.org.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao paymentDao;

    @Override
    public Payment get(String serial) {
        return new Payment("100",serial);
    }
}
