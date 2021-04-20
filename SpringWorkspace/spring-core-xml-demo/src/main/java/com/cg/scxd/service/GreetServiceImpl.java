package com.cg.scxd.service;

public class GreetServiceImpl implements IGreetService {

	@Override
	public String getGreeting(String userName) {
		return "Hello "+userName;
	}

}
