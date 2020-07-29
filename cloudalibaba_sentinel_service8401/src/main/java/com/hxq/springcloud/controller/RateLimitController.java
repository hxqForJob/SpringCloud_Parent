package com.hxq.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hxq.springcloud.pojo.CommonResult;
import com.hxq.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @RequestMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handleException")
    public CommonResult<String> getByResource(){
        CommonResult<String> commonResult = new CommonResult<String>("200", "成功", "success");
        return  commonResult;
    }

    public  CommonResult<String> blockByResource(BlockException blockException){
        CommonResult<String> commonResult = new CommonResult<String>("502", "失败", blockException.toString());
        return  commonResult;
    }

    @RequestMapping("/byUrl")
    @SentinelResource("byUrl")
    public  String buUrl(){
        return "byUrl";
    }
}
