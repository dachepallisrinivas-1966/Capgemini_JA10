package com.cg.scxd.ui;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.scxd.service.GreetServiceAdvancedImpl;
import com.cg.scxd.service.GreetServiceArgumentImpl;
import com.cg.scxd.service.GreetServiceImpl;
import com.cg.scxd.service.IGreetService;

public class App1 {

	public static void main(String[] args) {
		// we should not use implementation class
		GreetServiceImpl greetService = new GreetServiceImpl();
		System.out.println(greetService.getGreeting("Srinivas"));
		
		// use always interface on the left side and implementation class on the right side
		// program-to-interface concept
		IGreetService greetService2 = new GreetServiceImpl();
		System.out.println(greetService2.getGreeting("Raghu"));
		
		// spring way
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");

		IGreetService greetService3 = context.getBean("gsBean", GreetServiceImpl.class);
		System.out.println(greetService3.getGreeting("Vamsy"));
		
		// setter (property) injection
		IGreetService greetService4 = context.getBean("gsArgBean", GreetServiceArgumentImpl.class);
		System.out.println(greetService4.getGreeting("Shreya"));
		
		// constructor injection
		IGreetService greetService5 = context.getBean("gsArgBean2", GreetServiceArgumentImpl.class);
		System.out.println(greetService5.getGreeting("Kriti"));
		
		IGreetService greetService6 = context.getBean("gsArgBean2", GreetServiceArgumentImpl.class);
		System.out.println(greetService6.getGreeting("Ananya"));
		
		IGreetService greetService7 = context.getBean("gsAdvBean", GreetServiceAdvancedImpl.class);
		System.out.println(greetService7.getGreeting("Gunjan"));
		
		context.close();
	}

}
