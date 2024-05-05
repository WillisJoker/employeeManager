package com.nutc.employeeManager.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutc.employeeManager.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	void deleteEmployeeById(Integer id);

	Optional<Employee> findEmployeeById(Integer id);
}
