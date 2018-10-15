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
	    com.caidonglun.feign.HelloRemote HelloRemote;
	
	@Autowired
	LoadBalancerClient loadBalancerClient;
	
	@RequestMapping("/index")
	@ResponseBody
	public Object index() {
		logger.info("我是hystrix中的服务正在被访问中……");
//		填写第一个参数为其它Eureka服务器的项目名，也可以自己指定项目名，第二个是返回类型
		return restTemplate.getForObject("http://eureka-ribbon/index", String.class);
	}
	
	//用来获取被选中的服务器
	@RequestMapping("log-user-instance")
	@ResponseBody
	public void logUserInstance() {
		ServiceInstance instance=this.loadBalancerClient.choose("eureka-ribbon");
		logger.info("{}:{}:{}",instance.getServiceId(),instance.getHost(),instance.getPort());
	}
	
//	    想测试hystrix必须将eureka-ribbon服务器关闭才能看到访问失败的效果，就是防止服务器产生的雪球反应。
	    @RequestMapping("/indexFeigin")
	    @ResponseBody
	    public String indexFeign() {
	    	logger.info("我是Feigin中的方法！！！我正在调用eureka-ribbon中的服务！！！");
	        return HelloRemote.index();
	    }

	
	
}
