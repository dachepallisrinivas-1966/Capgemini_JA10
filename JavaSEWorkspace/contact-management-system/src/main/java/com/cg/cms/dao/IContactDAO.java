package com.cg.cms.dao;

import java.util.List;

import com.cg.cms.entity.Contact;
import com.cg.cms.exception.CMSException;

public interface IContactDAO {
	Contact add(Contact contact) throws CMSException;
	Contact save(Contact contact) throws CMSException;
	boolean deleteById(long contactId) throws CMSException;
	Contact getById(long contactId) throws CMSException;
	List<Contact> getAll() throws CMSException;
	
	String INSERT_CONTACT = "INSERT INTO contacts (cid, cname, dob, mobile) VALUES (?,?,?,?)";
	String UPDATE_CONTACT = "UPDATE contacts SET cname = ?, dob = ?, mobile = ? WHERE cid = ?";
	String DELETE_CONTACT = "DELETE FROM contacts WHERE cid = ?";
	String GET_CONTACT_BY_ID = "SELECT cid, cname, dob, mobile FROM contacts WHERE cid = ?";
	String GET_ALL_CONTACTS = "SELECT cid, cname, dob, mobile FROM contacts";
	
}
