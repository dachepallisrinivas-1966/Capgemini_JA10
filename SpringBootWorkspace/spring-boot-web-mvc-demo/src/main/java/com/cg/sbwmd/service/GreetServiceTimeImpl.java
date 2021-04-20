package com.cg.sbwmd.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

@Service(value = "gst")
public class GreetServiceTimeImpl implements IGreetService {

	@Override
	public String getMessage(String name) {
		String note = "Good Night";

		LocalTime time = LocalTime.now();
		int hour = time.getHour();
		if (hour >= 4 && hour <= 11)
			note = "Good Morning";
		if (hour > 11 && hour <= 16)
			note = "Good Afternoon";
		else if (hour > 16 && hour <= 18)
			note = "Good Evening";

		return note + " " + name;
	}

}
