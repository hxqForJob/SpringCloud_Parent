package com.hxq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderZk8004Main {
    public static void main(String[] args) {
        SpringApplication.run(ProviderZk8004Main.class,args);
    }
}
