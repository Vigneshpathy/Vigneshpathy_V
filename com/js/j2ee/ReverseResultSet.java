package com.js.j2ee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ReverseResultSet {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","handball22&&");
		
		
	}
}
