package com.caidonglun.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name="eureka-ribbon-hystrix")
@ComponentScan("com.caidonglun.controller")
@EnableCircuitBreaker
@EnableHystrix
public class SpringCloudRibbonHytrixApplication {

	@Bean
//	负载功能
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudRibbonHytrixApplication.class, args);
	}
	
	@Bean
	public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet(){

	   HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();

	   ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<HystrixMetricsStreamServlet>(streamServlet);

	   registrationBean.setLoadOnStartup(1);

	   registrationBean.addUrlMappings("/actuator/hystrix.stream");

	   registrationBean.setName("HystrixMetricsStreamServlet");


	   return registrationBean;
	}
}
