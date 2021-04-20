package com.cg.jhd.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cg.jhd.model.Address;

@Entity
@Table(name="customers")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="cid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="cname", length = 20, nullable = false)
	private String name;
	
	@Column(name="reg_date")
	private LocalDate registerDate;
	
	@Embedded
	private Address address;
	
	public Customer() {
		/* no implementation */
	}

	public Customer(String name, LocalDate registerDate, Address address) {
		super();
		this.name = name;
		this.registerDate = registerDate;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return String.format("id=%s, name=%s, registerDate=%s", id, name, registerDate);
	}
	
	
}
