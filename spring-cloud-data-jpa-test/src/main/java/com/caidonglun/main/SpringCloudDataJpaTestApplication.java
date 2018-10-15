package com.caidonglun.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EntityScan("com.caidonglun.entity")
@ComponentScan("com.caidonglun.controller")
@EnableFeignClients(basePackages="com.caidonglun.feign")
public class SpringCloudDataJpaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDataJpaTestApplication.class, args);
	}
}
