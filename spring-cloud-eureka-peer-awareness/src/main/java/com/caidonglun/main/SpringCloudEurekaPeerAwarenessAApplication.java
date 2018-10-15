package com.caidonglun.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaServer
@ComponentScan("com.caidonglun.controller")
public class SpringCloudEurekaPeerAwarenessAApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaPeerAwarenessAApplication.class, args);
	}
}
