package com.cg.scxd.service;

public class GreetServiceArgumentImpl implements IGreetService {

	private String greetNote;
	
	public GreetServiceArgumentImpl() {
		/* no implementation required */
	}
	
	public GreetServiceArgumentImpl(String greetNote) {
		this.greetNote = greetNote;
	}
	
	public void setGreetNote(String greetNote) {
		this.greetNote = greetNote;
	}
	
	@Override
	public String getGreeting(String userName) {
		return greetNote + " " + userName;
	}

}
