package com.hxq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudAlibabaPayment9002Main {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaPayment9002Main.class,args);
    }
}
