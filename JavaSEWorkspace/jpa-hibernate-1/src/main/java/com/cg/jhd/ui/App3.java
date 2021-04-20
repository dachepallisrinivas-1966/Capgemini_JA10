package com.cg.jhd.ui;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.cg.jhd.entity.Customer;
import com.cg.jhd.util.JPAUtil;

public class App3 {

	public static void main(String[] args) {
		EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
		
		EntityManager em = factory.createEntityManager();
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter customer id : ");
		long customerId = scan.nextLong();
		
		Customer customer = em.find(Customer.class, customerId);
		
		if (customer != null) {
			EntityTransaction txn = em.getTransaction();
			txn.begin();
			em.remove(customer);
			txn.commit();
			System.out.println("customer with #" + customerId + " is removed");
		} else {
			System.out.println("Customer with #" + customerId + " is not found");
		}
		
		scan.close();
		JPAUtil.shutdown();
	}

}
