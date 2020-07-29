package com.hxq.springcloudalibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hxq.springcloud.pojo.CommonResult;

public class CustomerBlockHandler {
    public static CommonResult handleException(BlockException exception) {
        return new CommonResult("2020", "自定义限流处理信息....CustomerBlockHandler",exception.toString());

    }

}
