package com.cg.scad.config;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.cg.scad.service")
public class MyConfiguration {
	
	@Bean
	public LocalDateTime current() {
		return LocalDateTime.now();
	}
	
	@Bean
	public Scanner scan() {
		return new Scanner(System.in);
	}

}

