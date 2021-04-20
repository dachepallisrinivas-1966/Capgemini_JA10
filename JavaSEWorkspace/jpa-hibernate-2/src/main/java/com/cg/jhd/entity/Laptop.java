package com.cg.jhd.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="laptops")
public class Laptop implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="laptop_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long lid;
	
	@Column(name="brand", length=10)
	private String brand;
	
	@Column(name="price")
	private BigDecimal price;
	
	@OneToOne(mappedBy="laptop")
	private Employee employee;
	
	public Laptop() {
		/* no implementation */
	}

	public Laptop(String brand, BigDecimal price) {
		super();
		this.brand = brand;
		this.price = price;
	}

	public Long getLid() {
		return lid;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return String.format("lid=%s, brand=%s, price=%s", lid, brand, price);
	}
	
}
