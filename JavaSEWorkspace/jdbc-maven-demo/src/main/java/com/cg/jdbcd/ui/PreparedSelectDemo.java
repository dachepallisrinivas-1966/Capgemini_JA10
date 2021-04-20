package com.cg.jdbcd.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedSelectDemo {

	public static void main(String[] args) {

		String sql = "SELECT job_id, job_title, min_salary, max_salary FROM jobs";
		
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();) {
			
			System.out.println("Job Id\t\tJob Title\t\t\tMin Salary\tMax Salary");
			System.out.println("----------------------------------------------------------------------------------");
			
			while (rs.next()) {
				System.out.printf("%-15s%-35s%7d%7d\n", rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
			}
		} catch (SQLException excep) {
			System.out.println("insertion error : " + excep.getMessage());
		} 
	}

}
