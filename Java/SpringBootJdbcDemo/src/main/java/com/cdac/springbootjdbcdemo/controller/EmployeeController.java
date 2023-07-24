package com.cdac.springbootjdbcdemo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.springbootjdbcdemo.dao.EmployeeDao;
import com.cdac.springbootjdbcdemo.pojo.Employee;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeDao daoImpl;
	
	/* 
	 * request url : http://localhost:9009/getall
	 * request method : GET
	*/ 
	@GetMapping("/getall")
	public List<Employee> getAll() {
		List<Employee> lst = daoImpl.getAllEmployee();
		return lst;
	}
	
	/* 
	 * request url : http://localhost:9009/find?id=4
	 * request method : GET
	*/ 
	@GetMapping("/find")
	public Employee findEmployee(@RequestParam("e_id") int eid) {
		Employee employee = daoImpl.searchEmployee(eid);
		return employee;
	}
	
	/*
	 *  request url :- http://localhost:9009/addnew
	 *  request method :- POST
	 *  request header :- Content-Type : application/json
	 *  json to be sent in the request :-
	 *  	{
	 *  		"name" : "Bag",
	 *  		"price" : 2300
	 *  	}	
	*/
	@PostMapping("/addnew")
	public HashMap<String, String> addNew(@RequestBody Employee employee)
	{
		HashMap<String, String> hmap = new HashMap<>();
		if(daoImpl.addNewEmployee(employee))
			hmap.put("message", "success");
		else
			hmap.put("message", "failure");
		return hmap;
	}
	
	
	/*
	 *  request url :- http://localhost:9009/update
	 *  request method :- PUT
	 *  request header :- Content-Type : application/json
	 *  json to be sent in the request :-
	 *  	{
	 *  		"id" : 10,
	 *  		"name" : "VIP bags",
	 *  		"price" : 2700
	 *  	}	
	*/
	@PutMapping("/update")
	public HashMap<String, String> updateEmployee(@RequestBody Employee
			 employee) {
		HashMap<String, String> hmap = new HashMap<>();
		
		if(daoImpl.updateEmployee(employee))
			hmap.put("message", "success");
		else 
			hmap.put("message", "failure");
		
		return hmap;
	}
	
	/*
	 *  request url :- http://localhost:9009/delete/9
	 *  request method :- DELETE	
	*/
	@DeleteMapping("/delete/{id}")
	public HashMap<String, String> deleteEmployee(
			@PathVariable("id") int eid) {
		HashMap<String, String> hmap = new HashMap<>();
		if(daoImpl.deleteEmployee(eid))
			hmap.put("message", "success");
		else
			hmap.put("message", "failure");
		
		return hmap;
	}	
}
