package com.js.j2ee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableStmt {

	public static void main(String[] args) {
		
		try {
			Driver dr = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(dr);
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","handball22&&");
			CallableStatement cs= con.prepareCall("call emp.insert(5,'nithish','nithish@gamil.com',751234567876)");
			cs.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
