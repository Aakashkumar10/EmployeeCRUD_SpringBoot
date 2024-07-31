package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.entities.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeedao;

	@Override
	public Employee addEmployee(Employee employee) {

		employeedao.save(employee);

		return employee;
	}

	@Override
	public List<Employee> getEmployee() {

		return employeedao.findAll();
	}

	@Override
	public Employee getEmployee(long employeeId) {

		System.err.println(employeeId);
		Employee employee = new Employee();
		Optional<Employee> a = employeedao.findById(employeeId);
		if (a.isPresent()) {
			System.err.println("found");
			employee = a.get();

		} else {
			System.err.println("Not found");
		}
		return employee;

	}

	@Override
	public Employee updateEmployee(Employee employee) {

		employeedao.save(employee);

		return employee;

	}

	@Override
	public void deleteEmployee(long parseLong) {

		Employee entity = employeedao.getOne(parseLong);
		employeedao.delete(entity);

	}

}
