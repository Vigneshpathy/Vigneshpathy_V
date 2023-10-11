package com.js.jdbc.crud;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

public class EmployeeApp {

	static Connection con;
	static EmployeeLogic emplogic;
	static {
		System.out.println("=========================");
		System.out.println("WELCOME TO EMPLOYEE'S APP");
		System.out.println("=========================");
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "handball22&&");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	static {
		try {
			emplogic = new EmployeeLogic(DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "handball22&&"));
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {

		Scanner sc = new Scanner(System.in);
		try {
			selectOption(sc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.close();
			sc.close();
		}
	}

	public static void selectOption(Scanner sc) throws SQLException {

		boolean repeat = true;
		while (repeat) {
			System.out.println("=================");
			System.out.println("====HOME PAGE====");
			System.out.println("=================");
			System.out.println("select an option");
			System.out.println("=================");
			System.out.println("1) Add Employee");
			System.out.println("2) Remove Employee");
			System.out.println("3) Display Employee Details");
			System.out.println("4) Display Individual Employee Detail");
			System.out.println("5) Exit ");

			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				try {
					addEmp(sc);
				} catch (SQLIntegrityConstraintViolationException e) {
					System.err.println("Duplicate ID please try with other ID");
				}
				break;
			case 2:
				removeEmployee(sc);
				break;
			case 3:
				emplogic.dispalyAllEmp();
				break;
			case 4:
				displayEmployee(sc);
				break;
			case 5:
				repeat = false;
				break;
			default:
				System.out.println("INVALID OUTPUT>>>> TRY AGAIN!!!!!");
			}
		}

	}

	private static void displayEmployee(Scanner sc) {

		try {

			boolean flag = true;
			while (flag) {
				System.out.println("=====================");
				System.out.println("==DISPLAY EMPLOYEE===");
				System.out.println("=====================");
				System.out.println(
						"Select an Option to Display Employee by...\n1) By ID\n2) By Name\n3) Go to Home page");
				int value = sc.nextInt();
				sc.nextLine();
				switch (value) {
				case 1:
					displayEmployeeById(sc);
					break;
				case 2:
					displayEmployeeByName(sc);
					break;
				case 3:
					flag = false;
					break;
				default:
					System.out.println("Invalid Input..!!!");
				}
			}
		} catch (Exception e) {
			System.err.println("Something went wrong... please try again or Exit Display Details!!!");
			sc.nextLine();
			displayEmployee(sc);
		}

	}

	private static void displayEmployeeByName(Scanner sc) throws SQLException {

		System.out.println("Enter the name to display");
		String name = sc.nextLine();
		emplogic.displayEmpByName(name);

	}

	private static void displayEmployeeById(Scanner sc) throws SQLException {

		System.out.println("Enter the ID to display");
		int id = sc.nextInt();
		emplogic.displayEmpById(id);

	}

//
	private static void removeEmployee(Scanner sc) {

		boolean flag = true;
		while (flag) {
//			if (EmployeeLogic.employees.isEmpty()) {
//				System.err.println("Database is Empty..!!!");
//				return;
//			}
			System.out.println("=====================");
			System.out.println("===REMOVE EMPLOYEE===");
			System.out.println("=====================");
			System.out.println("Select an Option to remove Employee by...\n1) By ID\n2) By Name\n3) Go to Home Page");

			try {
				int value = sc.nextInt();
				sc.nextLine();
				switch (value) {
				case 1:
					removeEmployeById(sc);
					break;
				case 2:
					removeEmployeByName(sc);
					break;
				case 3:
					flag = false;
					break;
				default:
					System.err.println("Invalid Input..!!!");
				}
			} catch (Exception e) {
				System.err.println("Something went wrong.. please try again or Exit Remove Employee!!!");
				sc.nextLine();
				removeEmployee(sc);
			}
		}

	}

	private static void removeEmployeByName(Scanner sc) {

		System.out.println("Enter the name ");
		String name = sc.nextLine();
		try {
			emplogic.deleteEmpByName(name);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void removeEmployeById(Scanner sc) {

		System.out.println("Enter the ID to delete");
		int id = sc.nextInt();
		sc.nextLine();
		try {
			emplogic.deleteEmpById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void addEmp(Scanner sc) throws SQLException {
		System.out.println("Enter the id ");
		int id = addEmpId(sc);
		sc.nextLine();
		System.out.println("Enter the name  ");
		String name = addEmpName(sc);
		System.out.println("Enter the salary ");
		double sal = addEmpSal(sc);
		System.out.println("Enter the Phone Number ");
		long pNum = addEmpPhoneNumber(sc);
		emplogic.addEmp(new Employee(id, name, pNum, sal));
		System.out.println("Employee with ID[" + id + "] is added succussfully..///<<");
	}

	private static String addEmpName(Scanner sc) {
		try {
			String name = sc.nextLine();
			nameException(name);
			return name;
		} catch (Exception e) {
			System.err.println("INVALID NAME FORMAT!!! ");
			System.out.println("Enter the name again...");
			return addEmpName(sc);
		}

	}

	private static long addEmpPhoneNumber(Scanner sc) {
		try {
			long phNum = sc.nextLong();
			phoneNumberException(phNum);
			return phNum;
		} catch (Exception e) {
			System.err.println("INVALID Phone Number format!!!!! ");
			System.out.println("Enter the phone number again...");
			sc.nextLine();
			return addEmpPhoneNumber(sc);
		}
	}

	private static double addEmpSal(Scanner sc) {
		try {
			double sal = sc.nextDouble();
			salException(sal);
			return sal;
		} catch (Exception e) {
			System.err.println("INVALID SALARY FORMAT!!! ");
			System.out.println("Enter the salary again....");
			sc.nextLine();
			return addEmpSal(sc);
		}
	}

	private static int addEmpId(Scanner sc) {
		try {
			int id = sc.nextInt();
			idException(id);
			return id;
		} catch (Exception e) {
			System.err.println("INVALID ID FORMAT!!!! ");
			System.out.println("Enter the ID again....");
			sc.nextLine();
			return addEmpId(sc);
		}
	}

	private static void nameException(String name) {

		for (int i = 0; i < name.length(); i++) {
			if (!(name.charAt(i) >= 'A' && name.charAt(i) <= 'Z' || name.charAt(i) >= 'a' && name.charAt(i) <= 'z'
					|| name.charAt(i) == 32)) {
				throw new RuntimeException();

			}
		}

	}

	private static void idException(int id) {
		if (id <= 0) {
			throw new RuntimeException();
		}
	}

	private static void salException(double sal) {
		if (sal <= 0) {
			throw new RuntimeException();
		}
	}

	private static void phoneNumberException(long phoneNum) {
		if (phoneNum < 6000000000l) {
			throw new RuntimeException();
		}
	}

}
