package com.cg.scad.service;

import org.springframework.stereotype.Component;

@Component("gnps")
public class GreetNoteProviderSimpleImpl implements IGreetNoteProvider {

	@Override
	public String getGreetNote() {
		return  "Hello, Welcome";
	}

}
