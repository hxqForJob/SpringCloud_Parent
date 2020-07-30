package com.hxq.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hxq.springcloud.pojo.CommonResult;
import com.hxq.springcloud.pojo.Payment;
import com.hxq.springcloudalibaba.block.PaymentBlock;
import com.hxq.springcloudalibaba.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class CircleBreakerController {

    @Value("${service-url.nacos-user-service}")
    public   String serviceUrl;

    @Autowired
    public RestTemplate restTemplate;

    @Resource
    public PaymentService paymentService;

    @GetMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback",fallback ="handlerFallback",blockHandler = "blockHandler")
    public CommonResult fallback(@PathVariable(value = "id",required = false) Long id){
        if(id<0){
            throw new IllegalArgumentException("id不能小于0");
        }
        CommonResult result = restTemplate.getForObject(serviceUrl + "/paymentSQL/" + id, CommonResult.class);
        if(result.getData()==null){
            throw new NullPointerException("id不能为空");
        }
       return result;

    }

    //fallback
    public CommonResult handlerFallback(@PathVariable  Long id,Throwable e) {
        Payment payment = new Payment(id,"null");
        return new CommonResult<Payment>("444","兜底异常handlerFallback,exception内容  "+e.getMessage(),payment);
    }

    //blockHandler
    public CommonResult blockHandler(@PathVariable  Long id, BlockException blockException) {
        Payment payment = new Payment(id,"null");
        return new CommonResult<Payment>("445","blockHandler-sentinel限流,无此流水: blockException  "+blockException.getMessage(),payment);
    }


    @GetMapping("/consumer/openfeign/{id}")
    @SentinelResource(value = "openfeign",blockHandlerClass = PaymentBlock.class,blockHandler = "blockHandler1")
    public  CommonResult paymentSql(@PathVariable("id")Long id){
        CommonResult<Payment> result = paymentService.paymentSQL(id);
        return  result;
    }
}
