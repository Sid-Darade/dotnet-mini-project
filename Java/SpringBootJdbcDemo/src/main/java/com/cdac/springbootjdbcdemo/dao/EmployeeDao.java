package com.cdac.springbootjdbcdemo.dao;

import java.util.List;

import com.cdac.springbootjdbcdemo.pojo.Employee;

public interface EmployeeDao {
	List<Employee> getAllEmployee();
	Employee searchEmployee(int eid);

	
	boolean addNewEmployee(Employee employee);
	boolean updateEmployee(Employee employee);
	boolean deleteEmployee(int eid);
}
