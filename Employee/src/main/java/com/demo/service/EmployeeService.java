package com.demo.service;

import java.util.List;

import com.demo.dto.EmployeeDto;

public interface EmployeeService {
	
	public EmployeeDto addEmployee(EmployeeDto employeeDto);
	
	public List<EmployeeDto> getAllEmployees();
	
	public EmployeeDto getById(int id);
	
	public EmployeeDto updateEmployee(int id,EmployeeDto employeeDto);
	
	public Boolean deleteById(int id);
}
