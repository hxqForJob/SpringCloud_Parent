package com.hxq.springcloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalance {
    ServiceInstance getRoundServiceInstance(List<ServiceInstance> serviceInstances);
}
