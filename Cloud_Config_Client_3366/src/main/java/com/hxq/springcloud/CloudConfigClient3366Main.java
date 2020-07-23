package com.hxq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudConfigClient3366Main {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigClient3366Main.class,args);
    }
}
