package com.cg.scxd.service;

public class GreetServiceAdvancedImpl implements IGreetService {

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
