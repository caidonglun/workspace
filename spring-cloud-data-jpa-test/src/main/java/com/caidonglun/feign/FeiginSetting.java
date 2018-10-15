package com.caidonglun.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="feigin-consumer")
public interface FeiginSetting {

	@RequestMapping(value="/index")
	String index();
}
