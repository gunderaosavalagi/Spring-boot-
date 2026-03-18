package com.student.service;

import com.student.dto.StudentDto;
import java.util.List;

import org.springframework.stereotype.Service;


public interface StudentService {
	
	public StudentDto addStudent(StudentDto studentDto);
	
	public List<StudentDto> getAllStudents();
	
	public StudentDto getStudentById(Long Id);
	
	public StudentDto updateStudent(Long Id,StudentDto studentDto);
	
	public Boolean deleteStudent(Long Id);
}
