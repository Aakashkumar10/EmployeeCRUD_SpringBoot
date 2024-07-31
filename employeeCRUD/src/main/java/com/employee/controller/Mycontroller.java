package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entities.Employee;
import com.employee.service.EmployeeService;

@RestController
public class Mycontroller {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return this.employeeService.addEmployee(employee);

	}

	@GetMapping("/employee")
	public List<Employee> getEmployee() {

		return this.employeeService.getEmployee();

	}
	
	@GetMapping("/employee/{employeeId}")
	public Employee getEmployee(@PathVariable String employeeId) {

		return this.employeeService.getEmployee(Long.parseLong(employeeId));
	}
	

	
	@PutMapping("/employee/{employeeId}")
	public Employee updateEmployee(@RequestBody  Employee employee)
	{
		return this.employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public ResponseEntity<HttpStatus>  deleteEmployee (@PathVariable String employeeId)
	{
		try
		{
			this.employeeService.deleteEmployee(Long.parseLong(employeeId));
			return new ResponseEntity<>(HttpStatus.OK);
			
		}catch (Exception e) {
			
			
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	
		
		
	
	
	
}
