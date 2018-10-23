package com.laonog.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@SpringCloudApplication
@ComponentScan(basePackages = {"com.laonog.admin", "com.laonog.common.bean"})
public class LaonogAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(LaonogAdminApplication.class, args);
    }
}