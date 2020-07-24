package com.hxq.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudAlibabaOrder6060Main {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaOrder6060Main.class,args);
    }
}
