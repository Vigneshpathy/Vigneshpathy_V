package com.js.j2ee;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;
public class JdbcProperties {

	public static void main(String[] args) throws Exception {
		
		Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		FileInputStream fis = new FileInputStream("D:\\java eclipse\\j2ee-jspiders-project\\src\\com\\js\\j2ee\\abc.properties");
		
		Properties p = new Properties();
		p.load(fis);
		
		String url = p.getProperty("dburl");
		
		Connection con = DriverManager.getConnection(url,p);
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

