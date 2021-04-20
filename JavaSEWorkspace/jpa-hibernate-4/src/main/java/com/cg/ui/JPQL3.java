package com.cg.ui;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.cg.entity.Employee;
import com.cg.jhd.util.JPAUtil;

public class JPQL3 {

	public static void main(String[] args) {
		EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();

		EntityManager em = factory.createEntityManager();
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter least salary : ");
		int leastSalary = scan.nextInt();
		System.out.print("Enter highest salary : ");
		int highestSalary = scan.nextInt();
		
		
		// positional parameters
		String jpql = "SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2";
		TypedQuery<Employee> tqry = em.createQuery(jpql, Employee.class);
		tqry.setParameter(1, leastSalary);
		tqry.setParameter(2, highestSalary);
		
		List<Employee> employees = tqry.getResultList();
		
		if (employees.isEmpty()) {
			System.out.println("No employees found");
		} else {
			employees.stream().forEach(System.out::println);
			System.out.println("No. of Employees = "+employees.size());
		}
		scan.close();
		JPAUtil.shutdown();

	}

}
