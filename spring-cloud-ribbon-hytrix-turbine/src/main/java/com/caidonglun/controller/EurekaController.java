package com.caidonglun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Controller
public class EurekaController {

	Logger logger= LoggerFactory.getLogger(getClass());
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	LoadBalancerClient loadBalancerClient;
	
	@RequestMapping("/index")
	@ResponseBody
	@HystrixCommand(fallbackMethod = "fallbackIndex")
	public Object index() {
		logger.info("我是ribbon-hystrix种的服务正在被访问中……");
//		填写第一个参数为其它Eureka服务器的项目名，也可以自己指定项目名，第二个是返回类型
		return restTemplate.getForObject("http://eureka-ribbon/index", String.class);
	}
	
	public Object fallbackIndex() {
		
		return "index主界面访问失败了！";
		
	}
	
	@HystrixCommand(fallbackMethod = "fallbackIndex")
	@RequestMapping("/loginfirst")
	@ResponseBody
	public Object login() {
		return "loginfirst!";
	}
	
}
