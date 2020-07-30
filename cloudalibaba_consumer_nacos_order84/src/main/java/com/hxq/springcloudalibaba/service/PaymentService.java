package com.hxq.springcloudalibaba.service;

import com.hxq.springcloud.pojo.CommonResult;
import com.hxq.springcloud.pojo.Payment;
import com.hxq.springcloudalibaba.fallback.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)

public interface PaymentService
{
    @GetMapping(value = "/paymentSQL/{id}")
     CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}

