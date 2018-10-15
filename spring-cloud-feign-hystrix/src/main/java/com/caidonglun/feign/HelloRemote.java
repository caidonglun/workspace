package com.caidonglun.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.caidonglun.hystrix.firstHystrixUse;
//使用hystrix需要指定fallback
@FeignClient(name= "eureka-ribbon",fallback=firstHystrixUse.class)
public interface HelloRemote {
    @RequestMapping(value = "/index")
    String index(/*@RequestParam(value = "name") String name*/);
}