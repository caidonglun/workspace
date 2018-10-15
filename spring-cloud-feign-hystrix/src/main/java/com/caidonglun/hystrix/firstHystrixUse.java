package com.caidonglun.hystrix;

import org.springframework.stereotype.Component;

import com.caidonglun.feign.HelloRemote;

@Component
public class firstHystrixUse implements HelloRemote {

	@Override
	public String index() {
		return "hello User /index the message send failed!!! might not online…";
	}

}
