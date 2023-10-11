package com.js.jdbc.crud;

public class Employee {

	private int id ;
	private String name;
	private long contact;
	private double salary;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public long getContact() {
		return contact;
	}
	public double getSalary() {
		return salary;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public Employee(int id, String name, long contact, double salary) {
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.salary = salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	

}
