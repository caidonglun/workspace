package com.caidonglun.feigns;

import org.springframework.cloud.openfeign.FeignClient;
import com.caidonglun.configuration.configurationFeign;

import feign.RequestLine;

//name参数和url参数都可以，相对而言还是那么方便一些。name为EUREKA-RIBBON，url为http://localhost:8091。
@FeignClient(name="EUREKA-RIBBON",configuration=configurationFeign.class)
public interface FeiginClientSetting {

	@RequestLine("GET /index")
	String index();
	
	
}
