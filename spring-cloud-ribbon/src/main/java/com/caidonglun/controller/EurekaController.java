package com.caidonglun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class EurekaController {

	Logger logger= LoggerFactory.getLogger(getClass());
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	LoadBalancerClient loadBalancerClient;
	
	@RequestMapping("/index")
	@ResponseBody
	public Object index() {
		logger.info("我是ribbon种的服务正在被访问中……");
//		填写第一个参数为其它Eureka服务器的项目名，也可以自己指定项目名，第二个是返回类型
		logUserInstance();
		return restTemplate.getForObject("http://eureka-ribbon/index", String.class);
	}
	
	@RequestMapping("log-user-instance")
	@ResponseBody
	public void logUserInstance() {
		ServiceInstance instance=this.loadBalancerClient.choose("eureka-ribbon");
		logger.info("{}:{}:{}",instance.getServiceId(),instance.getHost(),instance.getPort());
		System.out.println();
	}
	
}
