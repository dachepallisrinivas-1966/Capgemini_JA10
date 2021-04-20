package com.cg.jhd.ui;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.cg.jhd.entity.Course;
import com.cg.jhd.entity.Student;
import com.cg.jhd.util.JPAUtil;

public class App4 {

	public static void main(String[] args) {
		EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
		
		EntityManager em = factory.createEntityManager();
		
		Course c1 = new Course("ruby", new BigInteger("5700"));
		Student s1 = new Student("Rachana");
		Student s2 = new Student("Ankita");
		Student s3 = new Student("Siddhardh");
		Set<Student> students = new HashSet<>();
		
		students.add(s1); students.add(s2); students.add(s3);
		
		c1.setStudents(students);
		s1.setCourse(c1);
		s2.setCourse(c1);
		s3.setCourse(c1);
		
		
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(c1);
		txn.commit();
		
		JPAUtil.shutdown();
	}

}
