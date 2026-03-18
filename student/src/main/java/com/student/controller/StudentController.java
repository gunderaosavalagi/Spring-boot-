package com.student.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import com.student.dto.StudentDto;
import com.student.service.StudentService;

import jakarta.websocket.server.PathParam;
import jdk.jfr.Description;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@Description("To add student deatils")
	@PostMapping(value="/add",consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto studentDto){
		StudentDto dto=service.addStudent(studentDto);
		return new ResponseEntity<>(dto,HttpStatus.CREATED);	
	}
	
	
	@Description("To find student deatils")
	@GetMapping(value="/display{studentId}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<StudentDto> getById(@PathVariable("studentId") long studentId){
		StudentDto dto=service.getStudentById(studentId);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	@Description("To Display all student details")
	@GetMapping(value="/dispalyAll",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<StudentDto>> getAll(){
		List<StudentDto> dto=service.getAllStudents();
		return new ResponseEntity<List<StudentDto>>(dto,HttpStatus.OK);
	}
	
	@Description("To delete the student")
	@DeleteMapping(value="/delete{studentId}")
	public ResponseEntity<Boolean> delete(@PathVariable("studentId") Long studentId){
		Boolean res=service.deleteStudent(studentId);
		return new ResponseEntity<Boolean>(res,HttpStatus.OK);
	}
	
	@Description("To update the student")
	@PutMapping(value="/update{studentId}",consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<StudentDto> update(@PathVariable("studentId") Long studentId,@RequestBody StudentDto studentDto){
		StudentDto dto=service.updateStudent(studentId, studentDto);
		return new ResponseEntity<StudentDto>(dto,HttpStatus.OK);
	}
	
}
