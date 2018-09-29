package com.laonog.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *注册中心服务启动
 */
@EnableEurekaServer
@SpringBootApplication
public class LaonogEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaonogEurekaApplication.class, args);
	}
}
