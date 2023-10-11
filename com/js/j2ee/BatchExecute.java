package com.js.j2ee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class BatchExecute {

	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","handball22&&");
//		Statement st = con.createStatement();
//		st.addBatch("insert into emp.employee value(55,'veera','veera@gmail.com',9876423456),(44,'nithis','nithis@gmail.com',5678235299);");
//		st.addBatch("update employee set contact=7358802249 where id = 55");
//		st.addBatch("delete from employee where id = 44");
//		st.addBatch("insert into employee value(67,'vicky','vicky@gamil.com',9500835102)");
//		st.executeBatch();
		//================================================================
//		PreparedStatement ps = con.prepareStatement("insert into employee value(?,?,?,?)");
//		ps.setInt(1, 101);
//		ps.setString(2, "vickyveera");
//		ps.setString(3, "vickyveera@gmail.com");
//		ps.setLong(4, 6352821917l);
//		ps.addBatch();
//		ps.setInt(1, 102);
//		ps.setString(2, "vickyveera");
//		ps.setString(3, "vickyveera@gmail.com");
//		ps.setLong(4, 6352821917l);
//		ps.addBatch();
//		ps.setInt(1, 103);
//		ps.setString(2, "vickyveera");
//		ps.setString(3, "vickyveera@gmail.com");
//		ps.setLong(4, 6352821917l);
//		ps.addBatch();
//		ps.setInt(1, 104);
//		ps.setString(2, "vickyveera");
//		ps.setString(3, "vickyveera@gmail.com");
//		ps.setLong(4, 6352821917l);
//		ps.addBatch();
//		ps.setInt(1, 105);
//		ps.setString(2, "vickyveera");
//		ps.setString(3, "vickyveera@gmail.com");
//		ps.setLong(4, 6352821917l);
//		ps.addBatch();
//		int[] arr =ps.executeBatch();
//		System.out.println(Arrays.toString(arr));
		PreparedStatement ps = con.prepareStatement("select * from employee where id <110");
		ResultSet rs = ps.getResultSet();
		rs.last();
		while (rs.previous()) {
			System.out.println("ID :: " + rs.getInt(1) + "\nName :: " + rs.getString(2) + "\nContact :: "
					+ rs.getLong(3) + "\nSalary :: " + rs.getDouble(4));
			
		}
	}

}
