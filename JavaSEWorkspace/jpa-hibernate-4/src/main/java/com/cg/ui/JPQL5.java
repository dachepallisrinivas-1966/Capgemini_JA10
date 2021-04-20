package com.cg.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.cg.jhd.util.JPAUtil;

public class JPQL5 {

	public static void main(String[] args) {
		EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();

		EntityManager em = factory.createEntityManager();
		
		TypedQuery<Long> tqry = em.createQuery("SELECT COUNT(e) FROM Employee e", Long.class);
		long count = tqry.getSingleResult();
		System.out.println("No. of employees = " + count);
		
		TypedQuery<Double> tqry2 = em.createQuery("SELECT AVG(e.salary) FROM Employee e", Double.class);
		double avgSalary = tqry2.getSingleResult();
		System.out.println("Average Salary = " + avgSalary);
		
		JPAUtil.shutdown();

	}

}
