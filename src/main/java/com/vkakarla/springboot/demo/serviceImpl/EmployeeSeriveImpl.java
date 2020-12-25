package com.vkakarla.springboot.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vkakarla.springboot.demo.entities.Employee;
import com.vkakarla.springboot.demo.repo.EmployeeRepository;
import com.vkakarla.springboot.demo.service.EmployeeService;

@Service
public class EmployeeSeriveImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public void saveEmployee(Employee employee) {

		employeeRepository.save(employee);

	}
	
}
