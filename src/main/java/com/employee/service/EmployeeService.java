package com.employee.service;

import java.util.List;
import com.employee.entity.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(Long id);

	Employee updateEmployeeById(Long id, Employee employee);

	void deleteEmployeeById(Long id);
}
