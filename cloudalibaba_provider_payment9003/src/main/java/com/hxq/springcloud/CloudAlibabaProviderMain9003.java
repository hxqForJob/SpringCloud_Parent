package com.hxq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaProviderMain9003 {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaProviderMain9003.class,args);
    }
}
