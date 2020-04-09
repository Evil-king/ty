package com.ty.user.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableFeignClients("com.ty.product.feign")
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.ty.user.api.dao"})
@ComponentScan("com.ty")
public class UserApp {

    public static void main(String[] args) {
        SpringApplication.run(UserApp.class,args);
    }
}
