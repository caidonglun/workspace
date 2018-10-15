package com.caidonglun.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages="com.caidonglun.feigns")
@ComponentScan("com.caidonglun.*")
public class SpringCloudFiegnApplication {
	
//	@Bean
//	负载功能
//	@LoadBalanced
//	RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
	

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFiegnApplication.class, args);
	}
}
