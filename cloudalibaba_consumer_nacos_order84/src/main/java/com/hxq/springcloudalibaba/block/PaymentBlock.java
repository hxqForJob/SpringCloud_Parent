package com.hxq.springcloudalibaba.block;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hxq.springcloud.pojo.CommonResult;
import com.hxq.springcloud.pojo.Payment;

public class PaymentBlock {

    public static CommonResult blockHandler1(Long id, BlockException blockEx){
        Payment payment = new Payment(id,"null");
     return new CommonResult<Payment>("445","blockHandler-sentinel限流,无此流水: blockException  "+blockEx.getMessage(),payment);
    }
}
