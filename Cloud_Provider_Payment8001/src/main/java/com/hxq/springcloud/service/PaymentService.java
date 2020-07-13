package com.hxq.springcloud.service;

import com.hxq.springcloud.pojo.Payment;

public interface PaymentService {

    /**
     * 根据Id查询支付
     * @param id
     * @return
     */
    Payment getPaymentById(int id);

    /**
     * 添加支付
     * @param serial
     * @return
     */
    int addPayment(String serial);
}
