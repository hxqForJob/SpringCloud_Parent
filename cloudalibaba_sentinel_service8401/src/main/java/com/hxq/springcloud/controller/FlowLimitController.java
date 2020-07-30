package com.hxq.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hxq.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 限流，降级，熔断业务控制器
 */
@RestController
public class FlowLimitController
{
    @Autowired
   private   OrderService orderService;

    @GetMapping("/testA")
    public String testA() throws InterruptedException {

        //Thread.sleep(1000);
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {

        return "------testB";
    }

    @GetMapping("/testC")
    public String testC(int num) throws Exception {
        if(num<0){
            throw new RuntimeException("参数不能小于0");
        }
        return "------testC";
    }

    @GetMapping("/orderA")
    public String getOrderA() {

        return  orderService.getOrder();
    }

    @GetMapping("/orderB")
    public String getOrderB() {

        return  orderService.getOrder();
    }
    @GetMapping("/param")
    @SentinelResource(value = "paramTest",blockHandler = "block_paramTest")
    public String paramTest(@RequestParam(value = "p1",required = false)String p1,
                            @RequestParam(value = "p2",required = false)String p2)
    {
        return  "调用参数微服务,p1:"+p1+",p2:"+p2;
    }

    public String block_paramTest(String p1, String p2, BlockException blockException){
        return blockException.getMessage();
    }

}
