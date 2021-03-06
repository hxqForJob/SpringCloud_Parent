package com.hxq.springcloud.controller;

import com.hxq.springcloud.pojo.CommonResult;
import com.hxq.springcloud.pojo.Payment;
import com.hxq.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private  String port;

    @Autowired
     private PaymentService paymentService;

    @RequestMapping("/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") int id) throws InterruptedException {
        //Thread.sleep(6000);
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


    @GetMapping("/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }
}
