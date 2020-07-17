package com.hxq.springcloud.service;

import com.hxq.springcloud.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentService {

    @RequestMapping("/payment/getPaymentById/{id}")
     CommonResult getPaymentById(@PathVariable("id") int id);

    @RequestMapping("/payment/payment/get")
    String get();

}
