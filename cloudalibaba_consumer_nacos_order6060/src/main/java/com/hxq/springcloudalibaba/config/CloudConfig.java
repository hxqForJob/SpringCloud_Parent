package com.hxq.springcloudalibaba.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * cloud配置
 */
@Configuration
public class CloudConfig {

    /**
     * 配置一个具有负载均衡的restTemplate
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate()
    {
        return  new RestTemplate();
    }
}
