package com.laonog.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 获取用户信息也是通过这个应用实现
 * 认证服务器&资源服务器
 */
@SpringCloudApplication
@EnableFeignClients
@ComponentScan(basePackages = {"com.laonog.auth", "com.laonog.common.bean"})
public class LaonogAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LaonogAuthServerApplication.class, args);
    }

}
