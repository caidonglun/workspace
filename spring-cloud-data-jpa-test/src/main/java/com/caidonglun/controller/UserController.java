package com.caidonglun.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caidonglun.entity.User;
import com.caidonglun.feign.FeiginSetting;
import com.caidonglun.main.UserDao;

@Controller
public class UserController {

	Logger logger=LoggerFactory.getLogger(getClass());
	
	@Autowired
	UserDao dao;
	
	@Autowired
	FeiginSetting feign;
	
	@RequestMapping("/index/{id}")
	@ResponseBody
	public Optional<User> findUser(@PathVariable Long id) {
		logger.info("id=>"+id);
		logger.info("return------>"+dao.findById(id).toString());
		
		logger.info("正在使用feigin-consumer中微服务！");
		feign.index();
		
		return dao.findById(id);
		
	}
	
	
	
}
