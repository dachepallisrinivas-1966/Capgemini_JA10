package com.cg.ui;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.cg.entity.Employee;
import com.cg.jhd.util.JPAUtil;

public class JPQL2 {

	public static void main(String[] args) {
		EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();

		EntityManager em = factory.createEntityManager();
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter least salary : ");
		int leastSalary = scan.nextInt();
		System.out.print("Enter highest salary : ");
		int highestSalary = scan.nextInt();
		
		
		// :lsal and :hsal are named parameters
		String jpql = "SELECT e FROM Employee e WHERE e.salary BETWEEN :lsal AND :hsal";
		TypedQuery<Employee> tqry = em.createQuery(jpql, Employee.class);
		tqry.setParameter("lsal", leastSalary);
		tqry.setParameter("hsal", highestSalary);
		
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
