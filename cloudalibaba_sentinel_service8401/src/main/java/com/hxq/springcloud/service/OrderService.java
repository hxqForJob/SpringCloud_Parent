package com.hxq.springcloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    @SentinelResource(value = "getOrder",blockHandler = "block_getOrder")
    public  String  getOrder(){
        return "生成订单："+ UUID.randomUUID().toString();
    }

    public   String block_getOrder(BlockException blockException){
        return "生成失败。。。。。"+blockException.getMessage();
    }
}
