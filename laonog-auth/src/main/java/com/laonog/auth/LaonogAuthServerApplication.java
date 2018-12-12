package com.laonog.auth;

import com.laonog.common.security.feign.EnablePigxFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 获取用户信息也是通过这个应用实现
 * 认证服务器&资源服务器
 */
@SpringCloudApplication
@EnablePigxFeignClients
public class LaonogAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LaonogAuthServerApplication.class, args);
    }

}
