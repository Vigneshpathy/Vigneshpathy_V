package com.js.j2ee;

import java.sql.*;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class ConnectMysql {

	public static void main(String[] args) throws SQLException {
		Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?user=root&&password=Handball22&&");
		PreparedStatement pst = con.prepareStatement("select * from student where id =?");
		
		Scanner sc = new Scanner(System.in);
		pst.setInt(1, 1);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next())
		{

				System.out.println("ID :: " + rs.getInt(1) + "\nName :: " + rs.getString(2) + "\nContact :: "
						+ rs.getLong(3) + "\nSalary :: " + rs.getDouble(4));
		}

		
		System.out.println();

	
	}

}
