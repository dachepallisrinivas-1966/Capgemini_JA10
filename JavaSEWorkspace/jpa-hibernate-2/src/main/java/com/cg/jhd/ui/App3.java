package com.cg.jhd.ui;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.cg.jhd.entity.Course;
import com.cg.jhd.entity.Student;
import com.cg.jhd.util.JPAUtil;

public class App3 {

	public static void main(String[] args) {
		EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
		
		EntityManager em = factory.createEntityManager();
		
		Course course = em.find(Course.class, 2L);
		if (course != null) {
			System.out.println(course);
			Set<Student> students = course.getStudents(); 
			if (students.isEmpty()) {
				System.out.println("No students enrolled for the course " + course.getName());
			} else {
				for(Student student : students) {
					System.out.println(student);
				}
			}
		}
		
		JPAUtil.shutdown();
	}

}
