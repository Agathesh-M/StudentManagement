package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.EmployeeModel;
import com.example.demo.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<EmployeeModel> getAllEmployees() {
		return employeeRepository.findAll();
		
	}
	
	@Override
	public void saveEmployee(EmployeeModel employee) {
		this.employeeRepository.save(employee);		
	}

	@Override
	public EmployeeModel getEmployeeById(short id) {
		Optional<EmployeeModel> optional=employeeRepository.findById(id);
		EmployeeModel employee =null;
		if(optional.isPresent())
		{
			employee=optional.get();
		}
		else
		{
			throw new RuntimeException("Employee not found for id:: " +id);
		}
		return employee;
	}

	@Override
	public void deleteById(short id) {
		this.employeeRepository.deleteById(id);
		
	}
	
	
	

}
