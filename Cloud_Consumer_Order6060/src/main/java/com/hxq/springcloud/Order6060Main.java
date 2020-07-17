package com.hxq.springcloud;

import com.hxq.springcloud.config.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrix
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyRule.class)
public class Order6060Main {
    public static void main(String[] args) {
        SpringApplication.run(Order6060Main.class,args);
    }
}
