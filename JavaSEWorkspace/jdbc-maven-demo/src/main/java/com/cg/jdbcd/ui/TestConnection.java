package com.cg.jdbcd.ui;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			DatabaseMetaData dbmd = con.getMetaData();
			System.out.println(dbmd.getDatabaseProductName());
			System.out.println(dbmd.getDatabaseProductVersion());
			
		} catch (ClassNotFoundException excep) {
			System.out.println("jdbc driver not found : " + excep.getMessage());
		} catch (SQLException excep) {
			System.out.println("database error : " + excep.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException excep) {
				System.out.println("could not close the connection : " + excep.getMessage());
			}
		}

	}

}
