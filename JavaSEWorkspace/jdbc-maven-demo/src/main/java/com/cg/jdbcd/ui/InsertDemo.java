package com.cg.jdbcd.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDemo {

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			 Scanner scan = new Scanner(System.in);) {
			
			Statement st = con.createStatement();
			System.out.print("Enter empno : ");
			int empNumber = scan.nextInt();
			System.out.print("Enter ename : ");
			String ename = scan.next();
			System.out.println("Enter date joined ");
			String dojStr = scan.next();
			System.out.println("Enter salary : ");
			double salary = scan.nextDouble();
			
			String sql = "INSERT INTO emp111 VALUES ( " + empNumber + ",'" + ename + "','" + dojStr + "'," + salary + ")";
			st.executeUpdate(sql);
			System.out.println("row inserted");
			
		} catch (SQLException excep) {
			System.out.println("insertion error : " + excep.getMessage());
		} 
	}

}
