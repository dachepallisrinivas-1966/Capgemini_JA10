package com.cg.cms.service;

import java.util.List;

import com.cg.cms.entity.Contact;
import com.cg.cms.exception.CMSException;

public interface IContactService {
	Contact add(Contact contact) throws CMSException;
	Contact save(Contact contact) throws CMSException;
	boolean deleteById(long contactId) throws CMSException;
	Contact getById(long contactId) throws CMSException;
	List<Contact> getAll() throws CMSException;
}
