package com.voiceofyou.blog;


import org.springframework.context.support.GenericXmlApplicationContext;

import com.voiceofyou.blog.domain.AppUser;
import com.voiceofyou.blog.service.UserService;

public class JpaUserTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:root-context.xml");
		ctx.refresh();
		
		System.out.println("App context initialized successfully");
		
		UserService userService = ctx.getBean("userService", UserService.class);
		
		AppUser user=new AppUser();
		user.setEmail("ql@qq.com");
		user.setPassword("password");
		user.setUserName("qilei");
		userService.addUser(user);
		

	}

}