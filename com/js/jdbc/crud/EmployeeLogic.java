package com.js.jdbc.crud;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeLogic {
	public EmployeeLogic() {}
	public EmployeeLogic(Connection con) throws IOException, SQLException {
		this();
		this.con = con;
	}

	Connection con;

	public void addEmp(Employee e) throws SQLException {
		PreparedStatement inps = con.prepareStatement("call emp.insert(?,?,?,?)");
		inps.setInt(1, e.getId());
		inps.setString(2, e.getName());
		inps.setLong(3, e.getContact());
		inps.setDouble(4, e.getSalary());
		inps.executeUpdate();
	}

	public void deleteEmpById(int id) throws SQLException {
		PreparedStatement deleteById = con.prepareStatement("delete from newemployee where id=?");
		deleteById.setInt(1, id);
		int n = deleteById.executeUpdate();
		if (n > 0) {
			System.out.println("Employee with ID[" + id + "] has removed...");
		} else {
			System.err.println("No such Employee is there to remove...");
		}
		deleteById.close();
	}

	public void deleteEmpByName(String name) throws SQLException {
		PreparedStatement deleteByName = con.prepareStatement("delete from newemployee where name=?");
		deleteByName = con.prepareStatement("delete from newemployee where name = ?");
		deleteByName.setString(1, name);
		int n = deleteByName.executeUpdate();
		if (n > 0) {
			System.out.println("Employee with name[" + name + "] has removed...");
		} else {
			System.err.println("No such Employee is there to remove...");
		}
		deleteByName.close();
	}

	public void displayEmpById(int id) throws SQLException {
		PreparedStatement ps = con.prepareStatement("select * from newemployee where id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		boolean flag = true;
		while (rs.next()) {
			System.out.println("ID :: " + rs.getInt(1) + "\nName :: " + rs.getString(2) + "\nContact :: "
					+ rs.getLong(3) + "\nSalary :: " + rs.getDouble(4));
			flag = false;
		}
		if (flag) {
			System.err.println("No such data present with name[" + id + "]");
		}
		ps.close();
	}

	public void displayEmpByName(String name) throws SQLException {
		PreparedStatement ps = con.prepareStatement("select * from newemployee where name = ?");
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		boolean flag = true;
		while (rs.next()) {
			System.out.println("ID :: " + rs.getInt(1) + "\nName :: " + rs.getString(2) + "\nContact :: "
					+ rs.getLong(3) + "\nSalary :: " + rs.getDouble(4));
			flag = false;
		}
		if (flag) {
			System.err.println("No such data present with name[" + name + "]");
		}
		ps.close();
	}

	public void dispalyAllEmp() throws SQLException {
		PreparedStatement ps = con.prepareStatement("select * from newemployee where id > 0");
		ResultSet rs = ps.executeQuery();
		boolean flag = true;
		while (rs.next()) {
			System.out.println("ID :: " + rs.getInt(1) + "\nName :: " + rs.getString(2) + "\nContact :: "
					+ rs.getLong(3) + "\nSalary :: " + rs.getDouble(4));
			if (flag) {
				flag = false;
			}
		}
		if (flag) {
			System.err.println("No data is created...!!!");
		}
		ps.close();
	}
}
