package com.hxq.springcloud.controller;

import com.hxq.springcloud.pojo.CommonResult;
import com.hxq.springcloud.pojo.Payment;
import com.hxq.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private  String port;

    @RequestMapping("/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") int id){
        Payment payment = paymentService.getPaymentById(id);
        CommonResult<Payment> result=new CommonResult<>("200","查询成功"+port,payment);
        return  result;
    }

    @RequestMapping("/addPayment/{serial}")
    public CommonResult getPaymentById(@PathVariable("serial") String serial){
        int i = paymentService.addPayment(serial);
        CommonResult<Integer> result=new CommonResult<>("200","添加成功"+port,i);
        return  result;
    }

    @RequestMapping("/payment/get")
    public  String get(){
        return  "payment:"+port+"--"+ UUID.randomUUID().toString();
    }
}
