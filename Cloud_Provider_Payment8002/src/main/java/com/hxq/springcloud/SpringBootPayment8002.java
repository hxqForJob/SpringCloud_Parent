package com.hxq.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan(basePackages = "com.hxq.springcloud.mapper")
@EnableEurekaClient
public class SpringBootPayment8002 {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootPayment8002.class,args);
    }
}
