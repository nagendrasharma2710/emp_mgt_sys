package com.employee.serviceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import org.springframework.util.StringUtils;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		Employee emp = new Employee();
		emp.setName(employee.getName());
		emp.setEmail(employee.getEmail());
		emp.setPhone(employee.getPhone());
		emp.setDescription(employee.getDescription());
		emp.setCode(employee.getCode());
		return employeeRepository.save(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
	}

	@Override
	public Employee updateEmployeeById(Long id, Employee employee) {
		Optional<Employee> employ = employeeRepository.findById(id);
		Employee emp = employ.get();
        emp.setName(employee.getName());
        emp.setCode(employee.getCode());
        emp.setPhone(employee.getPhone());
        emp.setEmail(employee.getEmail());
        emp.setDescription(employee.getDescription());
        employeeRepository.save(emp);
        return emp;
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
	}

}
