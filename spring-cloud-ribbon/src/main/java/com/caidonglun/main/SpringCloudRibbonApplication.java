package com.caidonglun.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.caidonglun.ribbonsetting.RibbonConfiguration;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name="eureka-ribbon",configuration=RibbonConfiguration.class)
@ComponentScan("com.caidonglun.controller")
public class SpringCloudRibbonApplication {

	@Bean
//	负载功能
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudRibbonApplication.class, args);
	}
}
