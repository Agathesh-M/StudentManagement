package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.EmployeeModel;


public interface EmployeeRepository extends JpaRepository<EmployeeModel, Short>{

}
