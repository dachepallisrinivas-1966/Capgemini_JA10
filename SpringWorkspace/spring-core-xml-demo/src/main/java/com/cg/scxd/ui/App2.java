package com.cg.scxd.ui;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.scxd.service.CountService;

public class App2 {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");

		CountService countService = context.getBean("countBean", CountService.class);
		System.out.println(countService.getCount());
		
		CountService countService2 = context.getBean("countBean", CountService.class);
		System.out.println(countService2.getCount());
		
		System.out.println(context.isPrototype("countBean"));
		System.out.println(context.isSingleton("countBean"));
		
		context.close();
	}

}
