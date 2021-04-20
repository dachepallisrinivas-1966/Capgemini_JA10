package com.cg.scad.ui;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.cg.scad.config.MyConfiguration;
import com.cg.scad.service.IGreetService;


public class App2 {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
		
		IGreetService igs = context.getBean("gsa", IGreetService.class);
		System.out.println(igs.getGreeting("Srinivas"));
		
		context.close();
	}

}
