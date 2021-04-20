package com.cg.cms.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long contactId;
	private String fullName;
	private LocalDate dateOfBirth;
	private String mobile;
	
	public Contact() {
		/* no implementation required */
	}

	public Contact(Long contactId, String fullName, LocalDate dateOfBirth, String mobile) {
		super();
		this.contactId = contactId;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.mobile = mobile;
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return String.format("contactId=%s, fullName=%s, dateOfBirth=%s, mobile=%s", contactId, fullName,
				dateOfBirth, mobile);
	}
}
