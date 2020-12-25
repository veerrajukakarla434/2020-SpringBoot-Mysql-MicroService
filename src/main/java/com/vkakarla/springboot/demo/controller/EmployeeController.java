package com.vkakarla.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vkakarla.springboot.demo.entities.Employee;
import com.vkakarla.springboot.demo.service.EmployeeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("employee-module")
public class EmployeeController {


	@Autowired
	EmployeeService employeeService;

	@ApiOperation(value = "Save employee")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Successfully Saved Employee.", response = EmployeeController.class),
			@ApiResponse(code = 500, message = "Internal server error.", response = Exception.class),
			@ApiResponse(code = 404, message = "Unable to find employees", response = Exception.class) })
	@PostMapping(value = "/saveEmployee")
	public ResponseEntity<Object> saveAllEmployees(@RequestBody Employee employee) {

		employeeService.saveEmployee(employee);

		return new ResponseEntity<Object>("Successfully Saved", HttpStatus.OK);
	}

}
