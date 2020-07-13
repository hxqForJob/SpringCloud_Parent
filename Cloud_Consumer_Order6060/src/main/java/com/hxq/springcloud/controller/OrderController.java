package com.hxq.springcloud.controller;

import com.hxq.springcloud.loadbalance.impl.LoadBalanceImpl;
import com.hxq.springcloud.pojo.CommonResult;
import com.hxq.springcloud.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    public DiscoveryClient discoveryClient;

    @Autowired
    public LoadBalanceImpl loadBalance;

    public  static  final String providerName="http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    public RestTemplate restTemplate;

    @RequestMapping("getPayment/{id}")
    public CommonResult getPaymentById(@PathVariable("id") int id){
        return restTemplate.getForObject(providerName+"/payment/getPaymentById/"+id,CommonResult.class);
    }

    @RequestMapping("/addPayment/{serial}")
    public CommonResult addPayment(@PathVariable("serial") String serial){
        return restTemplate.getForObject(providerName+"/payment/addPayment/"+serial,CommonResult.class);
    }

    @RequestMapping("/cusLB/{id}")
    public  CommonResult cusLB(@PathVariable("id")int id){
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instance = loadBalance.getRoundServiceInstance(serviceInstances);
        return  restTemplate.getForObject(instance.getUri()+"/payment/getPaymentById/"+id,CommonResult.class);
    }
}
