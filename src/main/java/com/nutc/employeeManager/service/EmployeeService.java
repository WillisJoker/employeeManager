package com.nutc.employeeManager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutc.employeeManager.dao.EmployeeRepository;
import com.nutc.employeeManager.exception.UserNotFoundException;
import com.nutc.employeeManager.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepository.save(employee);
	}

	public List<Employee> findAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee findEmployeeById(Integer id) {
		return employeeRepository.findEmployeeById(id)
				.orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found !"));
	}

	public void deleteEmployee(Integer id) {
		employeeRepository.deleteEmployeeById(id);
	}
}
