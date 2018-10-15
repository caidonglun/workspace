package com.caidonglun.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.caidonglun.controller")
public class SpringCloudEurekaRibbonTestApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaRibbonTestApplication.class, args);
	}
}
