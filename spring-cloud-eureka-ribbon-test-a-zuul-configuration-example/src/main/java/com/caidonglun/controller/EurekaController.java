package com.caidonglun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EurekaController {

	Logger logger= LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/index")
	@ResponseBody
	public Object index() {
		logger.info("我是spring-cloud-eureka-ribbon-test-a-zuul-configuration-example的服务正在被访问中……");
		return "hello!!spring-cloud-eureka-ribbon-test-a-zuul-configuration-example!!";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public Object login() {
		logger.info("我是spring-cloud-eureka-ribbon-test-a-zuul-configuration-example的服务正在被访问中……");
		return "hello!!spring-cloud-eureka-ribbon-test-a-zuul-configuration-example!!";
	}
}
