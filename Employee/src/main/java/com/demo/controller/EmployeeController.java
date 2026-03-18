package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.EmployeeDto;
import com.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@Description("TO add employee deatils")
	@PostMapping(value="/add",consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto employee = service.addEmployee(employeeDto);
		return new ResponseEntity<EmployeeDto>(employee,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/displayAll",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> allEmployees = service.getAllEmployees();
		return new ResponseEntity<List<EmployeeDto>>(allEmployees,HttpStatus.OK);
	}
	
	@GetMapping(value="/display/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public  ResponseEntity<EmployeeDto> getById(@PathVariable("id") int id){
		EmployeeDto dto = service.getById(id);
		return new ResponseEntity<EmployeeDto>(dto,HttpStatus.OK);
	}
	
	@PutMapping(value="/update/{id}",consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE} )
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") int id,@RequestBody EmployeeDto employeeDto) {
		EmployeeDto updateEmployee = service.updateEmployee(id, employeeDto);
		return new ResponseEntity<EmployeeDto>(updateEmployee,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public  ResponseEntity<Boolean> deleteById(@PathVariable("id") int id){
		Boolean res = service.deleteById(id);
		return new ResponseEntity<Boolean>(res,HttpStatus.BAD_REQUEST);
	}
	

}
