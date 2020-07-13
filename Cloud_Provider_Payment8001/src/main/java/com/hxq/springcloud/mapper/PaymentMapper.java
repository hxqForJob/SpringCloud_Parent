package com.hxq.springcloud.mapper;

import com.hxq.springcloud.pojo.Payment;

public interface PaymentMapper {
    /**
     * 根据Id查询支付
     * @param id
     * @return
     */
     Payment getPaymentById(long id);

    /**
     * 添加支付
     * @param payment
     * @return
     */
     int addPayment(Payment payment);
}
