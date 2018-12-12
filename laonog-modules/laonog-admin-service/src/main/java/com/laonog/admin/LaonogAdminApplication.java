package com.laonog.admin;

import com.laonog.common.security.feign.EnablePigxFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 *
 * 用户统一管理系统
 */
@SpringCloudApplication
@EnablePigxFeignClients
public class LaonogAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(LaonogAdminApplication.class, args);
    }
}