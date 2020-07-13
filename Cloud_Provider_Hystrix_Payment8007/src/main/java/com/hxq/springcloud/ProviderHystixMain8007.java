package com.hxq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderHystixMain8007 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderHystixMain8007.class,args);
    }
}
