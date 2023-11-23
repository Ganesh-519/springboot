package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//get employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return this.employeeRepository.findAll();
	}
	
	@RequestMapping (value="/employee/{id}" ,method=RequestMethod.GET)
	public Class<? extends Object> getEmployee(@PathVariable ("id")int id) {
		return employeeRepository.findById(null).getClass();
	}

	@PostMapping ("/employee/hi")
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@PutMapping("/employee/update")
	public Employee updateEmployee(Employee employee) {
	return employeeRepository.save(employee);
	}

	@DeleteMapping ("/employee/{id}/")
	public void deleteEmployee(@PathVariable ("id") Long id) {
		employeeRepository.deleteById(id);
	}
	}


