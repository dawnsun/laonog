package com.laonog.config;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringCloudApplication
public class LaonogConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaonogConfigApplication.class, args);
	}
}
