package com.cdac.springbootjdbcdemo.pojo;

public class Employee {
	private int e_id;
	private String e_name;
	private int salary;

	public Employee() {
		
	}
	public int getE_id() {
		return e_id;
	}
	public String getE_name() {
		return e_name;
	}
	public int getSalary() {
		return salary;
	}
	
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
