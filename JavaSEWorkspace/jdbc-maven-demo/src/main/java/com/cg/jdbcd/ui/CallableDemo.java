package com.cg.jdbcd.ui;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallableDemo {

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");) {
			
				CallableStatement cs = con.prepareCall("{? =  call upper(?)");
				cs.registerOutParameter(1, Types.VARCHAR);
				cs.setString(2, "srinivas");
				cs.execute();
				System.out.println(cs.getString(1));
		} catch (SQLException excep) {
			System.out.println("insertion error : " + excep.getMessage());
		} 
	}

}
