package com.cg.scxd.service;

public class CountService {
	
	private int count;

	public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return ++count;
	}

	public void doInit() {
		System.out.println("Object initialized");
	}
	
	public void doDestroy() {
		System.out.println("Object destroyed");
	}
	
}
