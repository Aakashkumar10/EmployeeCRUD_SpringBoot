package com.employee.service;

import java.util.List;

import com.employee.entities.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee);

	public List<Employee> getEmployee();

	public Employee getEmployee(long employeeId);
	
	public Employee updateEmployee(Employee employee);
	
	public void deleteEmployee(long parseLong);
	
}
