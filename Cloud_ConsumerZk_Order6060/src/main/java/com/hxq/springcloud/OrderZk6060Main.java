package com.hxq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderZk6060Main {

    public static void main(String[] args) {
        SpringApplication.run(OrderZk6060Main.class,args);
    }
}
