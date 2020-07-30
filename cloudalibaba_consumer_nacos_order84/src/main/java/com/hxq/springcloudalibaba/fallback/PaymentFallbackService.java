package com.hxq.springcloudalibaba.fallback;

import com.hxq.springcloud.pojo.CommonResult;
import com.hxq.springcloud.pojo.Payment;
import com.hxq.springcloudalibaba.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * 服务降级
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>("4444","服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
