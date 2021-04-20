package com.cg.ui;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.cg.entity.ContractEmployee;
import com.cg.entity.Employee;
import com.cg.entity.Manager;
import com.cg.jhd.util.JPAUtil;

public class InheritanceApp {

	public static void main(String[] args) {
		EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();

		EntityManager em = factory.createEntityManager();

		Employee employee = new Employee(101L, "Srinivas");
		Manager manager = new Manager(102L, "Kumar", new BigInteger("15000"));
		ContractEmployee contractEmployee = new ContractEmployee(103L, "Rachana", new BigInteger("750"));
		
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(employee);
		em.persist(manager);
		em.persist(contractEmployee);
		txn.commit();
		
		JPAUtil.shutdown();

	}

}
