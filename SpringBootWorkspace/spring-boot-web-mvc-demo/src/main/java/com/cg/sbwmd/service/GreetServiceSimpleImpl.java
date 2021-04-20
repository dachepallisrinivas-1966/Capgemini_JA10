package com.cg.sbwmd.service;

import org.springframework.stereotype.Service;

@Service(value = "gss")
public class GreetServiceSimpleImpl implements IGreetService {

	@Override
	public String getMessage(String name) {
		return "Hello " + name + " !!!!";
	}

}
