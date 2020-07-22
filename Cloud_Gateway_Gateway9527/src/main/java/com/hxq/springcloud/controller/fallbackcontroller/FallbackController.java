package com.hxq.springcloud.controller.fallbackcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 网关降级处理
 */
@RestController
public class FallbackController {
    @RequestMapping("/defaultFallback")
    public String fallback() {
        return "网关降级，服务器发生hystrix降级处理";
    }
}
