package com.cg.scad.ui;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.cg.scad.config.MyConfiguration;


public class App1 {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
		
		LocalDateTime ldt = context.getBean("current", LocalDateTime.class);
		System.out.println(ldt.getDayOfMonth() + "/" + ldt.getMonthValue() + "/" + ldt.getYear());
		System.out.println(ldt.getHour() + ":" + ldt.getMinute() + ":" + ldt.getSecond());
		
		Scanner scan = context.getBean("scan", Scanner.class);
		System.out.print("Enter name : ");
		String name = scan.next();
		System.out.println("Hello " + name);
		
		context.close();
	}

}
