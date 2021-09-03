package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.EmployeeModel;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	
	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		model.addAttribute("listEmployees",employeeService.getAllEmployees());
		return "home";		
	}
	
	@GetMapping("/addEmployeeForm")
	public String addEmployeeForm(Model model) {
		EmployeeModel employee=new EmployeeModel();
		model.addAttribute("employee",employee);
		return "newEmployee";
		
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") EmployeeModel employee){
		//save employee to database
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value = "id") short id, Model model) {
		//getting employee from the service
		EmployeeModel employee=employeeService.getEmployeeById(id);
		//adding to the model to pre-populate in the view/form
		model.addAttribute("employee", employee);
		return "update";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable (value="id") short id)
	{
		this.employeeService.deleteById(id);
		return "redirect:/";
	}
	
	
}
