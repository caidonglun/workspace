package com.caidonglun.feigns;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name= "eureka-ribbon") 
public interface UserFeignClient {

	@RequestMapping(value = "/index")
	    String index();
	
}
