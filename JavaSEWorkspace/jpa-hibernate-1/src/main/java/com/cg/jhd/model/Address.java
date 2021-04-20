package com.cg.jhd.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	@Column(name="door_number", length=10)
	private String doorNumber;
	@Column(name="city", length=15)
	private String city;
	@Column(name="state", length=15)
	private String state;
	
	public Address() {
		/* no implementation required */
	}
	
	public Address(String doorNumber, String city, String state) {
		this.doorNumber = doorNumber;
		this.city = city;
		this.state = state;
	}

	public String getDoorNumber() {
		return doorNumber;
	}
	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
