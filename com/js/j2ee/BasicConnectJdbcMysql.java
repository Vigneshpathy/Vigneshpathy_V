package com.js.j2ee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class BasicConnectJdbcMysql {

	public static void main(String[] args) throws SQLException {
		Driver dr = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(dr);
		
		String url = "jdbc:mysql://localhost:3306/emp";
		String user = "root";
		String pass = "handball22&&";
		Connection con = DriverManager.getConnection(url,user,pass);
		
		Statement st = con.createStatement();
		
		int result = st.executeUpdate("delete from employee where id = 5");
		
		System.out.println(result);
		
		con.close();

	}

}
