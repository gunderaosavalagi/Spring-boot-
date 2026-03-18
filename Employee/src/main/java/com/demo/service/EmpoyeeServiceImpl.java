package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dto.EmployeeDto;
import com.demo.entity.EmployeeEntity;
import com.demo.exception.InvalidIdException;
import com.demo.repository.EmployeeRepository;

@Service
public class EmpoyeeServiceImpl  implements EmployeeService{
	
	@Autowired
	EmployeeRepository repository;
	
	@Override
	public EmployeeDto addEmployee(EmployeeDto employeeDto) {
		EmployeeEntity save = repository.save(convetEntity(employeeDto));
	    return convertDto(save);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		
	List<EmployeeEntity> entity=repository.findAll();
	List<EmployeeDto> list=new ArrayList<>();
	for(EmployeeEntity employeeEntity:entity) {
		list.add(convertDto(employeeEntity));
	}
		return list;
		
	}

	@Override
	public EmployeeDto getById(int id) {
		Optional<EmployeeEntity> optional = repository.findById(id);
		if(optional.isEmpty()) {
			throw new InvalidIdException(""+id);
		}
		EmployeeEntity entity=optional.get();
		return convertDto(entity);
	}

	@Override
	public EmployeeDto updateEmployee(int id, EmployeeDto employeeDto) {
		Optional<EmployeeEntity> optional = repository.findById(id);
		if(optional.isEmpty()) {
			throw new InvalidIdException(""+id);
		}
		EmployeeEntity employeeEntity=convetEntity(employeeDto);
		employeeEntity.setFirstName(employeeDto.getFirstName());
		employeeEntity.setLastName(employeeDto.getLastName());
		employeeEntity.setEmail(employeeDto.getEmail());
		employeeEntity.setPhoneNumber(employeeDto.getPhoneNumber());
		employeeEntity.setSalary(employeeDto.getSalary());
		EmployeeEntity save = repository.save(employeeEntity);
		return convertDto(save);
	}

	@Override
	public Boolean deleteById(int id) {
		Optional<EmployeeEntity> optional = repository.findById(id);
		if(optional.isPresent()) {  
			repository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public EmployeeEntity convetEntity(EmployeeDto dto) {
		return new EmployeeEntity(dto.getId(),dto.getFirstName(),dto.getLastName(),dto.getPhoneNumber(),dto.getEmail(),dto.getSalary());
	}
	
	public EmployeeDto convertDto(EmployeeEntity entity) {
		return new EmployeeDto(entity.getId(),entity.getFirstName(),entity.getLastName(),entity.getPhoneNumber(),entity.getEmail(),entity.getSalary());
	}

}
