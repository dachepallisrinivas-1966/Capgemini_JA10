package com.cg.jhd.ui;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.cg.jhd.entity.Customer;
import com.cg.jhd.model.Address;
import com.cg.jhd.util.JPAUtil;

public class App1 {

	public static void main(String[] args) {
		EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
		
		EntityManager em = factory.createEntityManager();
		
		Customer c1 = new Customer("srinivas", LocalDate.now(), new Address("1-1-1", "ABC Street", "Chennai"));
		Customer c2 = new Customer("divya", LocalDate.now().minusDays(1), new Address("2-2-2", "DEF Street", "Chennai"));
		Customer c3 = new Customer("rakesh", LocalDate.now().minusDays(2), new Address("3-3-3", "XYZ Street", "Bengaluru"));
		
		EntityTransaction txn = em.getTransaction();
		txn.begin();

		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		
		txn.commit();
		
		JPAUtil.shutdown();
	}

}
