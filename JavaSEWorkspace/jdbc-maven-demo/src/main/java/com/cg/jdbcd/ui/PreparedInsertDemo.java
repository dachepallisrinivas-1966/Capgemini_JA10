package com.cg.jdbcd.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedInsertDemo {

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			 Scanner scan = new Scanner(System.in);) {
			
			while (true) {
				System.out.print("Enter empno : ");
				int empNumber = scan.nextInt();
				if (empNumber <= 0)
					break;
				System.out.print("Enter ename : ");
				String ename = scan.next();
				System.out.println("Enter date joined ");
				String dojStr = scan.next();
				System.out.println("Enter salary : ");
				double salary = scan.nextDouble();
				
				String sql = "INSERT INTO emp111 VALUES ( ?, ?, ?, ? )";
			
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, empNumber);
				ps.setString(2, ename);
				ps.setString(3, dojStr);
				ps.setDouble(4, salary);
				
				ps.executeUpdate();
				System.out.println("row inserted");
			}
			
		} catch (SQLException excep) {
			System.out.println("insertion error : " + excep.getMessage());
		} 
	}

}
