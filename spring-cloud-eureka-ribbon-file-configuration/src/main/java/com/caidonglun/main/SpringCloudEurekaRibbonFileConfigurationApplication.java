package com.caidonglun.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.caidonglun.controller")
public class SpringCloudEurekaRibbonFileConfigurationApplication {

	@Bean
//	负载功能
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	 @Bean
	    public IRule ribbonRule() {
	        return new RandomRule();//这里配置策略，和配置文件对应
	    }
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaRibbonFileConfigurationApplication.class, args);
	}
}
