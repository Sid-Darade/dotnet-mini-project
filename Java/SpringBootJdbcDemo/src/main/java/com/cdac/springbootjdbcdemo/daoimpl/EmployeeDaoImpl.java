package com.cdac.springbootjdbcdemo.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cdac.springbootjdbcdemo.dao.EmployeeDao;
import com.cdac.springbootjdbcdemo.pojo.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	@Autowired
	private JdbcTemplate jTemplate;

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> lst = new ArrayList<>();
		
		try {
			lst = jTemplate.query("SELECT * FROM employee_spring", 
			new BeanPropertyRowMapper<Employee>(Employee.class));
			return lst;
		} 
		catch(EmptyResultDataAccessException exc) {
			return lst;
		}
		catch (Exception e) {
			e.printStackTrace();
			lst.clear();
			return lst;
		}
	}

	@Override
	public Employee searchEmployee(int eid) {
		try {
			Employee employee = jTemplate.queryForObject(
			"SELECT * FROM employee_spring WHERE e_id = ?", 
			new BeanPropertyRowMapper<Employee>(Employee.class) , eid);
			return employee;
		} 
		catch(EmptyResultDataAccessException exc) {
			return null;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addNewEmployee(Employee employee) {
		try {
			int count = jTemplate.update(
			"INSERT INTO employee_spring(e_id,e_name,salary) VALUES(?,?,?)" , 
			new Object[] {employee.getE_id(),employee.getE_name() , employee.getSalary()});
			
			if(count > 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		try {
			int count = jTemplate.update(
			"UPDATE employee_spring SET e_name = ? , salary = ? WHERE e_id = ?" , 
			new Object[] {employee.getE_name() , employee.getSalary() , 
					employee.getE_id()});
			
			if(count > 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteEmployee(int eid) {
		try {
			int count = jTemplate.update(
			"DELETE FROM employee_spring WHERE e_id = ?" , eid);
			
			if(count > 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
