package com.hxq.springcloud.loadbalance.impl;

import com.hxq.springcloud.loadbalance.LoadBalance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class LoadBalanceImpl implements LoadBalance {

    private AtomicInteger i=new AtomicInteger(0);
    @Override
    public ServiceInstance getRoundServiceInstance(List<ServiceInstance> serviceInstances) {
        int index=0;
        boolean flg;
        do {
            int current = this.i.get();
            flg = i.compareAndSet(current, current + 1);
           index=(current+1)%serviceInstances.size();
        }while (!flg);
        return  serviceInstances.get(index);
    }
}
