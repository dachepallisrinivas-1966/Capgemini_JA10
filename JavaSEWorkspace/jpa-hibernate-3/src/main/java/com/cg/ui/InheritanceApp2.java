package com.cg.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.cg.entity.Employee;
import com.cg.entity.Manager;
import com.cg.jhd.util.JPAUtil;

public class InheritanceApp2 {

	public static void main(String[] args) {
		EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();

		EntityManager em = factory.createEntityManager();

		Employee employee = em.find(Employee.class, 101L);
		if (employee!=null) {
			System.out.println(employee);
		} else {
			System.out.println("employee with #101 is not found");
		}
		
		Manager manager = em.find(Manager.class, 102L);
		if (manager != null) {
			System.out.println(manager);
		} else {
			System.out.println("employee with #102 is not found");
		}
		JPAUtil.shutdown();

	}

}
