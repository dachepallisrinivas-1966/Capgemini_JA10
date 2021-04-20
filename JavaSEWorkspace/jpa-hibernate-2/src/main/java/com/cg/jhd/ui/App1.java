package com.cg.jhd.ui;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.cg.jhd.entity.Employee;
import com.cg.jhd.util.JPAUtil;

public class App1 {

	public static void main(String[] args) {
		EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
		
		EntityManager em = factory.createEntityManager();
		
		Employee employee = em.find(Employee.class, 1L);
		if (employee != null) {
			System.out.println(employee);
			Scanner scan = new Scanner(System.in);
			System.out.print("Want to see laptop details [Y/N]?");
			String choice = scan.next();
			if (choice.equals("Y")) {
				System.out.println(employee.getLaptop());
			}
			scan.close();
			
		} else {
			System.out.println("Employee with #1 is not found");
		}
		JPAUtil.shutdown();
	}

}
