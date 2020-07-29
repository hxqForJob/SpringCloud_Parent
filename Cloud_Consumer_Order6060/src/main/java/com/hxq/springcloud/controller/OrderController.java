package com.hxq.springcloud.controller;

import com.hxq.springcloud.loadbalance.impl.LoadBalanceImpl;
import com.hxq.springcloud.pojo.CommonResult;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/order")
@Slf4j
@DefaultProperties(defaultFallback = "payment_global_fallbackMethd")
public class OrderController {

    @Autowired
    public DiscoveryClient discoveryClient;

    @Autowired
    public LoadBalanceImpl loadBalance;

    public  static  final String providerName="http://CLOUD-PAYMENT-SERVICE";

    public  static  final String providerHystrixName="http://CLOUD-PROVIDER-HYSTRIX-PAYMENT";

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

    @GetMapping("/payment/hystrix/timeout/{id}")
    //失败
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")  //3秒钟以内就是正常的业务逻辑
//    })
    @HystrixCommand(commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = restTemplate.getForObject(providerHystrixName+"/payment/hystrix/timeout/"+id,String.class);
        log.info("*******result:"+result);
        return result;
    }
    @RequestMapping("/cusLB/{id}")
    public  CommonResult cusLB(@PathVariable("id")int id){
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instance = loadBalance.getRoundServiceInstance(serviceInstances);
        return  restTemplate.getForObject(instance.getUri()+"/payment/getPaymentById/"+id,CommonResult.class);
    }

    public  String paymentInfo_TimeOutHandler(@PathVariable("id") Integer id){
        return "线程池123："+Thread.currentThread().getName()+"   系统繁忙, 请稍候再试  ,id：  "+id+"\t"+"哭了哇呜";
    }

    public String payment_global_fallbackMethd(){
        return "全局降级异常："+Thread.currentThread().getName()+" 系统繁忙, 请稍候再试,哭了哇呜";
    }
    // ====================> zipkin+sleuth
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject(providerName+"/payment/zipkin", String.class);
        return result;
    }
}
