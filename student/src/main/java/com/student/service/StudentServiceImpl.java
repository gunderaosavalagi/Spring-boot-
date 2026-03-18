package com.student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dto.StudentDto;
import com.student.entity.StudentEntity;
import com.student.exception.InvalidIdException;
import com.student.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{

    private final ModelMapper modelMapper;
	
	@Autowired
	StudentRepo repo;

    StudentServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

	@Override
	public StudentDto addStudent(StudentDto studentDto) {
		StudentEntity add=repo.save(convertEntity(studentDto));
		return convertDto(add);
	}
	
	@Override
	public List<StudentDto> getAllStudents() {
		List<StudentEntity> all = repo.findAll();
		List<StudentDto> list=new ArrayList<>();
		for(StudentEntity entity:all) {
			list.add(convertDto(entity));
		}
		return list;
	}

	@Override
	public StudentDto getStudentById(Long studentId) {
		Optional<StudentEntity> byId = repo.findById(studentId);
		if(byId.isEmpty()) {
			throw new InvalidIdException(""+studentId);
		}
		StudentEntity entity=byId.get();
		return convertDto(entity);
	}

	@Override
	public StudentDto updateStudent(Long studentId, StudentDto studentDto) {

	    StudentEntity entity = repo.findById(studentId)
	        .orElseThrow(() -> new InvalidIdException("" + studentId));

	    entity.setStudentName(studentDto.getStudentName());
	    entity.setStudentClass(studentDto.getStudentClass());
	    entity.setStudentPhoneNumber(studentDto.getStudentPhoneNumber());
	    entity.setStudentEmail(studentDto.getStudentEmail());

	    StudentEntity updated = repo.save(entity);

	    return convertDto(updated);
	}

	@Override
	public Boolean deleteStudent(Long studentId) {
		Optional<StudentEntity> optional = repo.findById(studentId);
		if(optional.isPresent()) {
			repo.deleteById(studentId);
			return true;
		}
		return false;
	}
	
//	public StudentEntity convertEntity(StudentDto dto) {
//		return new StudentEntity(dto.getStudentId(),dto.getStudentName(),dto.getStudentClass(),dto.getStudentPhoneNumber(),dto.getStudentEmail());
//	}
	public StudentEntity convertEntity(StudentDto dto) {
		return modelMapper.map(dto, StudentEntity.class);
	}
//	public StudentDto convertDto(StudentEntity entity) {
//		return new StudentDto(entity.getStudentId(),entity.getStudentName(),entity.getStudentClass(),entity.getStudentPhoneNumber(),entity.getStudentEmail());
//	}
	public StudentDto convertDto(StudentEntity entity) {
	    return modelMapper.map(entity, StudentDto.class);
	}
}
