package com.caidonglun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	Logger logger=LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/index")
	@ResponseBody
	public String index() {
		
		logger.info("hello-a");
		
		return "hello!!!A";
		
	}
	
	
	
}
