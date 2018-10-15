package com.caidonglun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caidonglun.feigns.UserFeignClient;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@Controller
public class FeignController {

	Logger logger=LoggerFactory.getLogger(getClass());
	
	@Autowired
	UserFeignClient userFeignClient;
	
	@RequestMapping("index")
	@ResponseBody
	public Object index() {
		logger.info("feign正在执行中！！");
		return userFeignClient.index();
	}
	
	@Autowired
	EurekaClient client;
//	
//	@Autowired
//	DiscoveryClient discoveryClient;
	
	@RequestMapping("homeurl")
	@ResponseBody
	public String serviceUrl() {
		InstanceInfo info=client.getNextServerFromEureka("FEIGIN-CONSUMER", false);
		return info.getHomePageUrl();
	}
	
//	本功能是用于查看注册eureka的基本信息。但是没有getLocalServiceInstance()方法使用失败。
//	@RequestMapping("instance")
//	@ResponseBody
//	public ServiceInstance getInstance() {
////		没有该方法啊！！！！！！
//		ServiceInstance info=(ServiceInstance) this.discoveryClient;//discoveryClient.getLocalServiceInstance()
//		return info;
//	}
	
	
}
