package com.cg.scad.service;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

@Component("gnpt")
public class GreetNoteProviderTimeImpl implements IGreetNoteProvider {

	@Override
	public String getGreetNote() {
		String note = "Good Night";
		
		LocalTime time = LocalTime.now();
		int hour = time.getHour();
		if (hour >= 4 && hour <= 11)
			note = "Good Morning";
		if (hour > 11 && hour <= 16)
			note = "Good Afternoon";
		else if (hour > 16 && hour <= 18)
			note = "Good Evening";
	
		return note;
	}

}
