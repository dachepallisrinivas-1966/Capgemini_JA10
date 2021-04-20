package com.cg.cms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.cms.entity.Contact;
import com.cg.cms.exception.CMSException;
import com.cg.cms.util.ConnectionFactory;

public class ContactDAOImpl implements IContactDAO {
	
	@Override
	public Contact add(Contact contact) throws CMSException {
		if (contact != null) {
			try (Connection con = ConnectionFactory.getConnection();
				 PreparedStatement pst = con.prepareStatement(INSERT_CONTACT);) {
				pst.setLong(1, contact.getContactId());
				pst.setString(2, contact.getFullName());
				pst.setDate(3, Date.valueOf(contact.getDateOfBirth()));
				pst.setString(4, contact.getMobile());
				pst.executeUpdate();
				
			} catch(SQLException excep) {
				throw new CMSException("Contact could not be saved");
			}
		}
		return contact;
	}

	@Override
	public Contact save(Contact contact) throws CMSException {
		if (contact != null) {
			try (Connection con = ConnectionFactory.getConnection();
				 PreparedStatement pst = con.prepareStatement(UPDATE_CONTACT);) {
				
				pst.setString(1, contact.getFullName());
				pst.setDate(2, Date.valueOf(contact.getDateOfBirth()));
				pst.setString(3, contact.getMobile());
				pst.setLong(4, contact.getContactId());
				pst.executeUpdate();
				
			} catch(SQLException excep) {
				throw new CMSException("Contact could not be updated");
			}
		}
		return contact;
	}

	@Override
	public boolean deleteById(long contactId) throws CMSException {
		boolean isDeleted = false;
		try (Connection con = ConnectionFactory.getConnection();
				 PreparedStatement pst = con.prepareStatement(DELETE_CONTACT);) {
				
				pst.setLong(1, contactId);
				int rowCount = pst.executeUpdate();
				isDeleted = rowCount > 0;
			} catch(SQLException excep) {
				throw new CMSException("Contact could not be deleted");
			}
		return isDeleted;
	}
	
	@Override
	public Contact getById(long contactId) throws CMSException {
		Contact contact = null;
		try (Connection con = ConnectionFactory.getConnection();
				 PreparedStatement pst = con.prepareStatement(GET_CONTACT_BY_ID);) {
				
				pst.setLong(1, contactId);
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					contact = new Contact();
					contact.setContactId(rs.getLong(1));
					contact.setFullName(rs.getString(2));
					contact.setDateOfBirth(rs.getDate(3).toLocalDate());
					contact.setMobile(rs.getString(4));
				}
		} catch(SQLException excep) {
			throw new CMSException("contact could not be retrieved");
		}
		
		return contact;
	}

	@Override
	public List<Contact> getAll() throws CMSException {
		List<Contact> contacts = new ArrayList<>();
		
		try (Connection con = ConnectionFactory.getConnection();
				 PreparedStatement pst = con.prepareStatement(GET_ALL_CONTACTS);) {
				
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					Contact contact = new Contact();
					contact.setContactId(rs.getLong(1));
					contact.setFullName(rs.getString(2));
					contact.setDateOfBirth(rs.getDate(3).toLocalDate());
					contact.setMobile(rs.getString(4));
					contacts.add(contact);
				}
				
				if (contacts.isEmpty()) {
					contacts = null;
				}
		} catch(SQLException excep) {
			throw new CMSException("contacts could not be retrieved");
		}
		
		return contacts;
	}

}
