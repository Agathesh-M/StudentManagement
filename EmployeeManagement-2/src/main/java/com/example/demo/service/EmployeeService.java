package com.example.demo.service;


import java.util.List;

import com.example.demo.model.*;

public interface EmployeeService {
	
	List<EmployeeModel> getAllEmployees();
	void saveEmployee(EmployeeModel employee);
	public EmployeeModel getEmployeeById(short id);
	void deleteById(short id);

}
