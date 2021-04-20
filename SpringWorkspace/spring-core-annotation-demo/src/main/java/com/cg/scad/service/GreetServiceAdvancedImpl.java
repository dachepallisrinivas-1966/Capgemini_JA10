package com.cg.scad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("gsa")
public class GreetServiceAdvancedImpl implements IGreetService {

	@Autowired
	@Qualifier(value = "gnpt")
	private IGreetNoteProvider greetNoteProvider;
	
	public IGreetNoteProvider getGreetNoteProvider() {
		return greetNoteProvider;
	}

	public void setGreetNoteProvider(IGreetNoteProvider greetNoteProvider) {
		this.greetNoteProvider = greetNoteProvider;
	}

	@Override
	public String getGreeting(String userName) {
		return greetNoteProvider.getGreetNote() + " " + userName; 
	}

}
