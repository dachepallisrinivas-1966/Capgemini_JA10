package com.cg.jhd.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="cname", length=30)
	private String name;
	
	@Column(name="fee")
	private BigInteger fee;
	
	@OneToMany(mappedBy="course", cascade = CascadeType.PERSIST)
	private Set<Student> students;
	
	public Course() {
		/* no implementation */ 
	}

	public Course(String name, BigInteger fee) {
		super();
		this.name = name;
		this.fee = fee;
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

	public BigInteger getFee() {
		return fee;
	}

	public void setFee(BigInteger fee) {
		this.fee = fee;
	}
	
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return String.format("id=%s, name=%s, fee=%s", id, name, fee);
	}
	
	
}
