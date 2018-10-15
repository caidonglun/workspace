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
		logger.info("我是eureka-ribbon的服务正在被访问中……");
		return "hello!!eurekaAndRibbon!!";
	}
	
}
