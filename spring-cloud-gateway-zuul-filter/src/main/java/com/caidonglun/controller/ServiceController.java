package com.caidonglun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@Controller
public class ServiceController {

	@Autowired
	EurekaClient client;
	
	@RequestMapping("geturl")
	@ResponseBody
	public String serviceUrl() {
		InstanceInfo info=client.getNextServerFromEureka("feigin-consumer", false);
		return info.getHomePageUrl();
	}
	
	
}
