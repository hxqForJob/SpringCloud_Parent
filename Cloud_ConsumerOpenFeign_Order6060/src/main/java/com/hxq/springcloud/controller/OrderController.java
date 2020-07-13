package com.hxq.springcloud.controller;

import com.hxq.springcloud.pojo.CommonResult;
import com.hxq.springcloud.service.PaymentService;
import com.sun.xml.internal.bind.v2.model.core.ID;
import io.micrometer.core.instrument.Meter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping("/getPayment/{id}")
    public CommonResult getPaymentById(@PathVariable("id") int id){
        return paymentService.getPaymentById(id);
    }
}
