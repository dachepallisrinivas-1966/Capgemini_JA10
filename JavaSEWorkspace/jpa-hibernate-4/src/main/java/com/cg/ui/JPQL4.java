package com.cg.ui;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.cg.entity.Employee;
import com.cg.jhd.util.JPAUtil;

public class JPQL4 {

	public static void main(String[] args) {
		EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();

		EntityManager em = factory.createEntityManager();
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter salary : ");
		int salary = scan.nextInt();
		
		TypedQuery<Employee> tqry = em.createNamedQuery("costly_employees", Employee.class);
		tqry.setParameter("sal", salary);
		
		List<Employee> employees = tqry.getResultList();
		
		if (employees.isEmpty()) {
			System.out.println("No employees found");
		} else {
			employees.stream().forEach(System.out::println);
			System.out.println("No. of Employees = "+employees.size());
		}
		
		System.out.println("-------------------------------------------------------------------");
		
		TypedQuery<Employee> tqry2 = em.createNamedQuery("moderate_employees", Employee.class);
		tqry2.setParameter("sal", salary);
		
		List<Employee> employees2 = tqry2.getResultList();
		
		if (employees2.isEmpty()) {
			System.out.println("No employees found");
		} else {
			employees2.stream().forEach(System.out::println);
			System.out.println("No. of Employees = "+employees2.size());
		}
		
		scan.close();
		JPAUtil.shutdown();

	}

}
