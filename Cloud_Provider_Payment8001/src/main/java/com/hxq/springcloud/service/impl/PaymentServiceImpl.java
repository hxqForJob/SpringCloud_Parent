package com.hxq.springcloud.service.impl;

import com.hxq.springcloud.mapper.PaymentMapper;
import com.hxq.springcloud.pojo.Payment;
import com.hxq.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;
    @Override
    public Payment getPaymentById(int id) {
        return paymentMapper.getPaymentById(id);
    }

    @Override
    public int addPayment(String serial) {
        Payment payment=new Payment();
        payment.setSerial(serial);
        return paymentMapper.addPayment(payment);
    }
}
