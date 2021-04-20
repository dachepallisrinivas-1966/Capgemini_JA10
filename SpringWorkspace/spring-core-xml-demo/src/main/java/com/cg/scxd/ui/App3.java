package com.cg.scxd.ui;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.scxd.service.IGreetService;

public class App3 {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans3.xml");
		IGreetService gsadv = context.getBean("gsAdvBean", IGreetService.class);
		System.out.println(gsadv.getGreeting("Srinivas"));
		context.close();
	}

}
