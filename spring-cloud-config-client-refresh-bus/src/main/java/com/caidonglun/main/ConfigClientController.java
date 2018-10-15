package com.caidonglun.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

	@Value("${profile}")
	private String profile;
	
	@RequestMapping("/profile")
	public String getProfile() {
		return this.profile;
		
	}
	
}
